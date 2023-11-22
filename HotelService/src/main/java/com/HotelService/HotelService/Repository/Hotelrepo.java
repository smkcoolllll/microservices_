package com.HotelService.HotelService.Repository;

import com.HotelService.HotelService.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Hotelrepo extends JpaRepository<Hotel,String> {
}
