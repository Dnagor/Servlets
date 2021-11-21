package com.example.servlets;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> userList = new ArrayList<>();
    private static UserService userService;

    private UserService(){
    }
    public static UserService getUserService(){
        if(userService == null){
            userService = new UserService();
        }
        return userService;
    }

    public List<User> getUserList(){
        return userList;
    }

    public void saveUser(User user){
        userList.add(user);
    }
    public User getUser(final String email){
        return userList.stream().filter(user -> user.getEmail().equals(email)).findAny().orElse(null);
    }
}
