package microservices.UserServices.services;

import microservices.UserServices.entities.User;

import java.util.List;

public interface UserServices {

    User saveUser(User user);

    List<User> getAllusers();

    User  getUser(String userid);



}
