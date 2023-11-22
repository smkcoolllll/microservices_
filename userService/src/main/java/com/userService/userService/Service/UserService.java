package com.userService.userService.Service;

import com.userService.userService.Entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUser();
    User getUser(String userId);
    void deleteUser(String userId);

    User updateUser(String userId, User updateUser);
//    delete update
//    User deleteUser(String userId);

}
