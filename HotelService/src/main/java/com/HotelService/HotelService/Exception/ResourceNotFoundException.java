package com.HotelService.HotelService.Exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String msg){
        super(msg);
    }
     public ResourceNotFoundException(){
         super("Hotel resource not found....");
     }
}
