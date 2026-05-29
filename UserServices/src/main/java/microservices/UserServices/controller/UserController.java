package microservices.UserServices.controller;

import microservices.UserServices.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import microservices.UserServices.services.UserServices;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServices userServices;
    @GetMapping("/test")
    public String test() {
        return "project is working";
    }
@PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User user1 = userServices.saveUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user1);

    }
    @GetMapping("/{userid}")
    public ResponseEntity<User> getUser(@PathVariable  String userid){

        User responseuser = userServices.getUser(userid);
return ResponseEntity.ok(responseuser);

    }
    @GetMapping
public ResponseEntity<List<User>> getallUser(){


        List<User> allusers = userServices.getAllusers();
        return ResponseEntity.ok(allusers);
    }
}
