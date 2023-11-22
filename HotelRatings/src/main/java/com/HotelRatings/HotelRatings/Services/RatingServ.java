package com.HotelRatings.HotelRatings.Services;

import com.HotelRatings.HotelRatings.Entity.Rating;

import java.util.List;

public interface RatingServ {
    Rating create(Rating rating);
    List<Rating> getAll();
    List<Rating> getRatingByUserId(String userId);
    List<Rating> getRatingByHotelId(String hotelId);
    Rating getSingleRating(String ratingId);

    Rating updateRfeedback(String ratingId, Rating rating);
}
