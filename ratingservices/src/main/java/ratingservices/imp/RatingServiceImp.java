package ratingservices.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ratingservices.entities.Rating;
import ratingservices.repositories.RatingRepository;
import ratingservices.service.RatingService;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImp implements RatingService {

    @Autowired
    RatingRepository ratingRepository;


    @Override
    public Rating create(Rating rating) {
        String randomId = UUID.randomUUID().toString();

        rating.setRatingId(randomId);

        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
