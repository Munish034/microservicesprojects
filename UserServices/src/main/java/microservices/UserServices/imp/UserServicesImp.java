package microservices.UserServices.imp;

import microservices.UserServices.entities.Hotel;
import microservices.UserServices.entities.Rating;
import microservices.UserServices.entities.User;
import microservices.UserServices.exception.ResourcenotfounfException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import microservices.UserServices.repository.UserRepository;
import microservices.UserServices.services.UserServices;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserServicesImp implements UserServices {

    @Autowired
    UserRepository userRepository;
    @Autowired
    public RestTemplate restTemplate;


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {


        String randomid = UUID.randomUUID().toString();

        user.setUserid(randomid);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllusers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userid) {


        User user = userRepository.findById(userid).orElseThrow(() -> new ResourcenotfounfException("user is not available with this is" + userid));
        Rating[] object = restTemplate.getForObject("http://RATINGSERVICES/ratings/users/" + user.getUserid(), Rating[].class);


        List<Rating> ratings = Arrays.stream(object).toList();
        List<Rating> hotelRating = ratings.stream().map(rating -> {

                    ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity("http://HOTELSERVICES/hotels/"+rating.getHotelId(), Hotel.class);

            
          Hotel hotel = hotelEntity.getBody();
                   /* Hotel hotel = hotelservice.getHotel(rating.getHotelId());*/
            logger.info("{}",hotelEntity.getStatusCode());
            System.out.println("hello");
                    rating.setHotelss(hotel);
                    return rating;
                }

        ).collect(Collectors.toList());

user.setRatings(hotelRating);
        return user;
    }
}
