package hotelservices.impl;

import hotelservices.entity.Hotel;
import hotelservices.exception.ResourceNotFoundException;
import hotelservices.repositories.HotelRepository;
import hotelservices.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelserviceImp implements HotelService {
    @Autowired
    HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {

        String hotelid = UUID.randomUUID().toString();
        hotel.setId(hotelid);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with this user id not found"));
    }
}
