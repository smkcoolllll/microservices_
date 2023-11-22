package com.userService.userService.ExternalServices;
import com.userService.userService.Entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
    @GetMapping("/hotel/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);

}
