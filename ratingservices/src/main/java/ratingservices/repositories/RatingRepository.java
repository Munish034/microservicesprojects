package ratingservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ratingservices.entities.Rating;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,String> {

    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

}
