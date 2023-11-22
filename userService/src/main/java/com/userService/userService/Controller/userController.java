package com.userService.userService.Controller;
import com.userService.userService.Entity.User;
import com.userService.userService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {

    @Autowired
    private UserService userserv;
    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1=userserv.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
       User user= userserv.getUser(userId);
       return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser=userserv.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    @DeleteMapping("/{userId}")
    public void removeUser(@PathVariable  String userId){
       userserv.deleteUser(userId);

    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUserr(@PathVariable String userId,@RequestBody User updated){
        User upUser=userserv.updateUser(userId,updated);
        return ResponseEntity.ok(upUser);
    }
}
