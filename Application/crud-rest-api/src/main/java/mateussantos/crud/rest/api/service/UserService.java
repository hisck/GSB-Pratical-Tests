package mateussantos.crud.rest.api.service;

import mateussantos.crud.rest.api.model.UserModel;
import mateussantos.crud.rest.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<UserModel> listAllUsers(){
        return (List<UserModel>) repository.findAll();
    }

    public ResponseEntity<UserModel> find(Integer id){
        return repository.findById(id)
                .map(record-> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    public String saveUser(UserModel user){
        String response;
        if(user.getId() != null){
            repository.save(user);
            response = "User data updated";
        }else{
            repository.save(user);
            response = "New user created";
        }
        return response;
    }

    public String deleteUser(Integer id){
        repository.deleteById(id);
        return "User deleted";
    }
}
