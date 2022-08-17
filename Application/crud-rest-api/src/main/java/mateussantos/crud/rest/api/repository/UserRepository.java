package mateussantos.crud.rest.api.repository;

import mateussantos.crud.rest.api.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Integer> {

}
