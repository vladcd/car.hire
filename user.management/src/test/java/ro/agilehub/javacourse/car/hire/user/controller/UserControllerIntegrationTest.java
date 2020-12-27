package ro.agilehub.javacourse.car.hire.user.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ro.agilehub.javacourse.car.hire.api.model.CreatedDTO;
import ro.agilehub.javacourse.car.hire.api.model.UserDTO;
import ro.agilehub.javacourse.car.hire.user.MockMvcSetup;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("integrationtest")
public class UserControllerIntegrationTest extends MockMvcSetup {

    @Test
    @WithMockUser("jack")
    public void whenAddUserOk_thenFindById() throws Exception {
        final String email = "vladcarcu@email.com";
        var input = new UserDTO().email(email);

        var postResult = mvc.perform(post("/user")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isCreated())
                .andReturn();

        var createdDTO = objectMapper.readValue(postResult.getResponse().getContentAsString(), CreatedDTO.class);

        var getResult = mvc.perform(get("/user/" + createdDTO.getId()))
                .andExpect(status().isOk())
                .andReturn();

        var userDTO = objectMapper.readValue(getResult.getResponse().getContentAsString(), UserDTO.class);

        assertEquals(email, userDTO.getEmail());
    }

    @Test
    @WithMockUser("jack")
    public void whenPatchUserOk_thenFindById() throws Exception {
        final String email = "vladcarcu+post@email.com";
        final String username = "vladcarcu+post";
        var input = new UserDTO()
                .email(email)
                .username(username);

        var postResult = mvc.perform(post("/user")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isCreated())
                .andReturn();

        var createdDTO = objectMapper.readValue(postResult.getResponse().getContentAsString(), CreatedDTO.class);

        mvc.perform(patch("/user/" + createdDTO.getId())
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk());
    }

}
