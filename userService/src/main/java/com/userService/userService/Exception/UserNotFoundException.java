package com.userService.userService.Exception;

public class UserNotFoundException extends RuntimeException{


    public UserNotFoundException(String message){
        super(message);
    }
}
