package com.HotelService.HotelService.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class staffController {
    @GetMapping
    public ResponseEntity<List<String>> getAllStaffs(){
        List<String> listy= Arrays.asList("rock","jhon","randy","cm-punk");
        return new ResponseEntity<>(listy,HttpStatus.OK);
    }
}
