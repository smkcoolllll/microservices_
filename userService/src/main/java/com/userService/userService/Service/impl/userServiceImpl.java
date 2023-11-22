package com.userService.userService.Service.impl;
import com.userService.userService.Entity.Hotel;
import com.userService.userService.Entity.Rating;
import com.userService.userService.Entity.User;
import com.userService.userService.Exception.UserNotFoundException;
import com.userService.userService.ExternalServices.HotelService;
import com.userService.userService.Repository.UserRepo;
import com.userService.userService.Service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserRepo userrepository;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelsrv;



    private Logger logger = LoggerFactory.getLogger(userServiceImpl.class);
    @Override
    public User saveUser(User user) {
        String randomeUserId=UUID.randomUUID().toString();
        user.setUserId(randomeUserId);
        return userrepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userrepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user= userrepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found with particular userId: " + userId));

        Rating[] ratingsOfUser=restTemplate.getForObject("http://RATING-SERVICE/ratings/ratingsByUser/"+user.getUserId(),Rating[].class);
        logger.info("{} ",ratingsOfUser);
        List<Rating> ratings= Arrays.stream(ratingsOfUser).toList();
        List<Rating> ratingList=ratings.stream().map(rating -> {
//            ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);
            Hotel hotel =hotelsrv.getHotel(rating.getHotelId());
//            logger.info("response status code : ",forEntity.getStatusCode());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return  user;
    }

    @Override
    public void deleteUser(String userId) {
        userrepository.deleteById(userId);

    }

    @Override
    public  User updateUser(String userId, User updateUser){
        User excitingUser=getUser(userId);
        excitingUser.setName(updateUser.getName());
        excitingUser.setAbout(updateUser.getAbout());
        return userrepository.save(excitingUser);
    }
}
