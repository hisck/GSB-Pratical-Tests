package mateussantos.crud.rest.api.controller;

import com.google.gson.Gson;
import mateussantos.crud.rest.api.model.UserModel;
import mateussantos.crud.rest.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    private static final Gson gson = new Gson();

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
    public ResponseEntity<String> createUser(@RequestBody UserModel user){
        try{
            return ResponseEntity.ok(gson.toJson(userService.saveUser(user)));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(gson.toJson("There was an error trying to create this user"));
        }
    }

        @PostMapping("update")
    public ResponseEntity<String> updateUser(@RequestBody UserModel user){
        try{
            return ResponseEntity.ok(gson.toJson(userService.saveUser(user)));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(gson.toJson("There was an error trying to update this user"));
        }
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
        try{
            return ResponseEntity.ok(gson.toJson(userService.deleteUser(id)));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(gson.toJson("Error trying to delete User data"));
        }
    }
}
