package com.luv2code.springdemo.service;
import com.luv2code.springdemo.dao.IPlaceDAO;
import com.luv2code.springdemo.entity.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PlaceServiceImpl implements IPlaceService {

    @Autowired
    private IPlaceDAO placeDAO;

    @Override
    public List getPlaces() {
       return placeDAO.getPlaces();
    }

    @Override
    public void savePlace(Place place) {
        placeDAO.savePlace(place);
    }

    @Override
    public Place getPlace(int id) {
        return placeDAO.getPlace(id);
    }

    @Override
    public void deletePlace(int id) {
        placeDAO.deletePlace(id);
    }
}
