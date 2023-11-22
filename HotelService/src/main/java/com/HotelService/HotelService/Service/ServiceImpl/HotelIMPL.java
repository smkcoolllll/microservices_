package com.HotelService.HotelService.Service.ServiceImpl;

import com.HotelService.HotelService.Entity.Hotel;
import com.HotelService.HotelService.Exception.ResourceNotFoundException;
import com.HotelService.HotelService.Repository.Hotelrepo;
import com.HotelService.HotelService.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelIMPL implements HotelService {

    @Autowired
    private Hotelrepo hotelRepo;
    @Override
    public Hotel create(Hotel hotel) {
        String hotelId= UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);

        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel get(String hotelId) {
        return hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with given hotelId is not found...."+hotelId));
    }

    @Override
    public  void deleteHotel(String hotelId){
        try {
            hotelRepo.deleteById(hotelId);
        }catch (ResourceNotFoundException exc){
            throw new ResourceNotFoundException("hotel with particular hotelId: "+hotelId+"not found...") ;
        }

    }

    @Override
    public Hotel updateHotel(String hotelId,Hotel hotel){
        Hotel updated=get(hotelId);
        updated.setHotelName(hotel.getHotelName());
        updated.setAboutHotel(hotel.getAboutHotel());
        return hotelRepo.save(updated);

    }
}
