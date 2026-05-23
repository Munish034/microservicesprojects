package ratingservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ratingservices.entities.Rating;
import ratingservices.imp.RatingServiceImp;
import ratingservices.service.RatingService;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    RatingService ratingService;
@PostMapping
    public ResponseEntity<Rating> create(@RequestBody  Rating rating){

        return  ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }
@GetMapping
    public ResponseEntity<List<Rating>> getAll(){

        return ResponseEntity.ok(ratingService.getAllRating());
    }
@GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){

        return  ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public  ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){

        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }


}
