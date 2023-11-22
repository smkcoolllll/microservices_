package jwtAuth_.jwtAuth_.controller;

import jwtAuth_.jwtAuth_.model.User;
import jwtAuth_.jwtAuth_.service.jwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/jwt")
public class jwtController {
    @Autowired
    private jwtService jwtsrv;

//    abdbfdf0-706f-48c0-95ed-d56c8cfe0097
    @GetMapping("/just")
    public List<User> justchecks(){
        return jwtsrv.getUser();
    }

    @GetMapping("/current")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }
}
