package hotelservices.controller;


import hotelservices.entity.Hotel;
import hotelservices.impl.HotelserviceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotels")
public class HotelController {
    @Autowired
    HotelserviceImp hotelserviceImp;
    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody  Hotel hotel){


        return  ResponseEntity.status(HttpStatus.CREATED).body(hotelserviceImp.create(hotel));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){

        return ResponseEntity.ok(hotelserviceImp.get(hotelId));
    }
    @GetMapping
    public  ResponseEntity<List<Hotel>> getAllhotels(){

        return  ResponseEntity.ok(hotelserviceImp.getAll());
    }

}
