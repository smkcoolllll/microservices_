package jwtAuth_.jwtAuth_.service;

import jwtAuth_.jwtAuth_.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class jwtService {

    private List<User> usr=new ArrayList<>();

     public  jwtService(){
         usr.add(new User(UUID.randomUUID().toString(),"Sam Jackson","sam@yahoo.com"));
         usr.add(new User(UUID.randomUUID().toString(),"Jhon Cena","jhon@yahoo.com"));
         usr.add(new User(UUID.randomUUID().toString(),"Dean Ambrose","dean@yahoo.com"));
         usr.add(new User(UUID.randomUUID().toString(),"Tim David","tim@yahoo.com"));
         usr.add(new User(UUID.randomUUID().toString(),"Great khali","great@yahoo.com"));

     }

     public List<User> getUser(){
         return this.usr;
    }
}
