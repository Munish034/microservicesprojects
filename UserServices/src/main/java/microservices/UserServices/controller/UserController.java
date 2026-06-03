package microservices.UserServices.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
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
        return "project is good working";
    }
@PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User user1 = userServices.saveUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user1);

    }
    @GetMapping("/test1")
    @Retry(name = "ratingRetry")
    public String test1() {

        System.out.println(++count);

        throw new RuntimeException("Test Retry");
    }
    int count=1;
    @GetMapping("/{userid}")

    @CircuitBreaker(name = "userServiceBreaker",fallbackMethod = "userServiceBreakerFallback")

    public ResponseEntity<User> getUser(@PathVariable  String userid){
        count++;
        System.out.println(++count);
        User responseuser = userServices.getUser(userid);

return ResponseEntity.ok(responseuser);

    }
    public  ResponseEntity<User> userServiceBreakerFallback(String userid,Exception ex){

        User user = User.builder().name("manish").about("java developer").email("EXCEPTION.OCCURED@").userid("12345").build();
return  new ResponseEntity<>(user,HttpStatus.OK);


    }
    @GetMapping
public ResponseEntity<List<User>> getallUser(){


        List<User> allusers = userServices.getAllusers();
        return ResponseEntity.ok(allusers);
    }
}
