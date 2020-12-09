package ro.agilehub.javacourse.car.hire.user.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ro.agilehub.javacourse.car.hire.user.repository.definition.UserRepository;
import ro.agilehub.javacourse.car.hire.user.repository.entity.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
public class UserRepositoryTest {

    private static final String USERNAME = "Username";

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        var user = new User();
        user.setUsername(USERNAME);

        testEntityManager.persist(user);
    }

    @Test
    public void findByName_whenNoMatch_returnEmpty() {
        var foundUser = userRepository.findByUsernameIgnoreCase("another");

        assertTrue(foundUser.isEmpty());
    }

    @Test
    public void findByName_whenMatch_return() {
        var foundUser = userRepository.findByUsernameIgnoreCase(USERNAME.toLowerCase());

        assertTrue(foundUser.isPresent());
        assertEquals(USERNAME, foundUser.get().getUsername());
    }
}
