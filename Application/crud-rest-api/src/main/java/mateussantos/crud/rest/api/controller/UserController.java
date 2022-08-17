package mateussantos.crud.rest.api.controller;

import mateussantos.crud.rest.api.model.UserModel;
import mateussantos.crud.rest.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping(path = "/api/user/{id}")
    public ResponseEntity<UserModel> find(@PathVariable("id") Integer id){
        return repository.findById(id)
                .map(record-> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/api/user/save")
    public UserModel save(@RequestBody UserModel user){
        return repository.save(user);
    }

}
