package mateussantos.crud.rest.api.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserModelTest {

    @Test
    public void userModelTest(){
        UserModel user = new UserModel();
        user.setId(999);
        user.setCity("teste");
        user.setAddress("teste");
        user.setEmail("teste@teste");
        user.setName("teste");
        user.setLogin("teste");
        user.setState("teste");
        user.setZipCode("999999");

        assertNotNull(user.getId());
        assertNotNull(user.getCity());
        assertNotNull(user.getAddress());
        assertNotNull(user.getEmail());
        assertNotNull(user.getName());
        assertNotNull(user.getLogin());
        assertNotNull(user.getState());
        assertNotNull(user.getZipCode());
    }
}
