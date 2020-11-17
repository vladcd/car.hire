package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ro.agilehub.javacourse.car.hire.api.model.ResourceCreatedDTO;
import ro.agilehub.javacourse.car.hire.api.model.ResponseDTO;
import ro.agilehub.javacourse.car.hire.api.model.User;
import ro.agilehub.javacourse.car.hire.api.specification.UserApi;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController implements UserApi {
    @Override
    public ResponseEntity<ResourceCreatedDTO> createUser(@Valid User user) {
        ResourceCreatedDTO resourceCreatedDTO = new ResourceCreatedDTO();
        resourceCreatedDTO.setId(1L);
        return ResponseEntity.ok(resourceCreatedDTO);
    }

    @Override
    public ResponseEntity<ResponseDTO> deleteUser(Integer id) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("User deleted successfully");
        return ResponseEntity.ok(responseDTO);
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers(@Valid String status) {
        List<User> users = new ArrayList<>();
        users.add(mockUser());
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<User> getUserByID(Integer id) {
        return ResponseEntity.ok(mockUser());
    }

    @Override
    public ResponseEntity<ResponseDTO> updateUserDetails(Integer id, @Valid User user) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("User info has been updated");
        return ResponseEntity.ok(responseDTO);
    }

    private User mockUser() {
        User user = new User();
        user.setId(1L);
        user.setFirstname("Alexandru");
        user.setLastname("Adam");
        user.setUsername("adamalexandru");
        user.setPassword("password");
        user.setCountryOfResidence("RO");
        user.setDriverLicenseNo("RO123123");

        return user;
    }
}
