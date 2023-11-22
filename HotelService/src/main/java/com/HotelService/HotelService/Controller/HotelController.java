package com.HotelService.HotelService.Controller;

import com.HotelService.HotelService.Entity.Hotel;
import com.HotelService.HotelService.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> saveHotelDetails(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
    }

    @GetMapping
    public  ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.ok(hotelService.getAll());
    }

    @DeleteMapping("/{hotelId}")
    public void deleteHotel(@PathVariable String hotelId){
        hotelService.deleteHotel(hotelId);
    }

    @PatchMapping("/{hotelId}")
    public ResponseEntity<Hotel> updateHotelDetails(@PathVariable String hotelId,@RequestBody Hotel hotel){
        return ResponseEntity.ok(hotelService.updateHotel(hotelId,hotel));
    }
}
