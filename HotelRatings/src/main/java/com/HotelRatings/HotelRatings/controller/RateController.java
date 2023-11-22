package com.HotelRatings.HotelRatings.controller;

import com.HotelRatings.HotelRatings.Entity.Rating;
import com.HotelRatings.HotelRatings.Services.RatingServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RateController {

    @Autowired
    private RatingServ ratesrv;
    @PostMapping
    public ResponseEntity<Rating> saveRatings(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.OK).body(ratesrv.create(rating));
    }

    @GetMapping("/ratingsByUser/{userId}")
    public ResponseEntity<List<Rating>> getRatingsBYuserId(@PathVariable String userId){
        return ResponseEntity.ok(ratesrv.getRatingByUserId(userId));
    }

    @GetMapping("/ratingsByHotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratesrv.getRatingByHotelId(hotelId));
    }
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.ok(ratesrv.getAll());
    }
    @PatchMapping("/update/{ratingId}")
    public ResponseEntity<Rating> updatefeed(@PathVariable String ratingId, @RequestBody Rating rating){
        Rating updd= ratesrv.updateRfeedback(ratingId,rating);
        return ResponseEntity.ok(updd);
    }
    @GetMapping("single/{ratingId}")
    public ResponseEntity<Rating> getSingleRating(@PathVariable String ratingId){
        return ResponseEntity.ok(ratesrv.getSingleRating(ratingId));
    }

}
