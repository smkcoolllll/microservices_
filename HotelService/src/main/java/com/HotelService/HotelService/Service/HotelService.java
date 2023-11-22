package com.HotelService.HotelService.Service;

import com.HotelService.HotelService.Entity.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {
     Hotel create(Hotel hotel);
    List<Hotel> getAll();

    Hotel get(String hotelId);

    void deleteHotel(String hotelId);

    Hotel updateHotel(String hotelId,Hotel hotel);

}
