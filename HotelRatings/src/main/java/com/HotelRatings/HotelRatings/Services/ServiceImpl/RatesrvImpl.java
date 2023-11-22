package com.HotelRatings.HotelRatings.Services.ServiceImpl;

import com.HotelRatings.HotelRatings.Entity.Rating;
import com.HotelRatings.HotelRatings.Repository.RatingRepo;
import com.HotelRatings.HotelRatings.Services.RatingServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatesrvImpl implements RatingServ {
    @Autowired
    private RatingRepo rateRepo;
    @Override
    public Rating create(Rating rating) {
        String randomeRatingId= UUID.randomUUID().toString();
        rating.setRatingId(randomeRatingId);
        return rateRepo.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return rateRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return rateRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return rateRepo.findByHotelId(hotelId);
    }

    @Override
    public Rating getSingleRating(String ratingId) {
        return rateRepo.findById(ratingId).orElseThrow();
    }

    @Override
    public Rating updateRfeedback(String ratingId, Rating rating) {
        Rating updatedRatings= rateRepo.findByRatingId(ratingId);
        updatedRatings.setFeedback(rating.getFeedback());
        rateRepo.save(updatedRatings);
        return updatedRatings;
    }
}
