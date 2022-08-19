package mateussantos.crud.rest.api.repository;

import mateussantos.crud.rest.api.model.UserModel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.util.Optional;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class UserTest {

    @Autowired
    UserRepository repository;

    @BeforeEach
    private void setUp() throws ParseException{
        UserModel user = new UserModel();
        user.setId(1000);
        user.setCity("teste");
        user.setAddress("teste");
        user.setEmail("teste@teste");
        user.setName("teste");
        user.setLogin("teste");
        user.setState("teste");
        user.setZipCode("999999");

        repository.save(user);

        UserModel user2 = new UserModel();
        user2.setId(1001);
        user2.setCity("teste");
        user2.setAddress("teste");
        user2.setEmail("teste@teste");
        user2.setName("teste");
        user2.setLogin("teste");
        user2.setState("teste");
        user2.setZipCode("999999");

        repository.save(user2);
    }
}
