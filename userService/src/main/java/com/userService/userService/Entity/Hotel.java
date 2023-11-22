package com.userService.userService.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Hotel {
    private String hotelId;
    private  String  hotelName;
    private String location;
    private String aboutHotel;
}
