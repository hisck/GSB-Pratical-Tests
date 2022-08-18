package mateussantos.crud.rest.api.controller;

import mateussantos.crud.rest.api.model.UserModel;
import mateussantos.crud.rest.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    UserService userService;

    /* List all users */
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public ResponseEntity<UserModel> find(@PathVariable("id") Integer id){
        return userService.find(id);
    }

    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("all")
    public List<UserModel> listAllUsers(){
        return userService.listAllUsers();
    }

    @PostMapping("create")
    public ResponseEntity<Object> createUser(@RequestBody UserModel user){
        try{
            return new ResponseEntity<Object>(userService.saveUser(user), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

        @PostMapping("update")
    public ResponseEntity<Object> updateUser(@RequestBody UserModel user){
        try{
            return new ResponseEntity<Object>(userService.saveUser(user), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Integer id){
        try{
            return new ResponseEntity<Object>(userService.deleteUser(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Object>("Error trying to delete User data", HttpStatus.BAD_REQUEST);
        }
    }
}
