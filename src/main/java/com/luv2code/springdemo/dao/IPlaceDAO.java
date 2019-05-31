package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Place;

import java.util.List;

public interface IPlaceDAO {

    List<Place> getPlaces();
    Place getPlace(int theId);
    void deletePlace(int theId);
    void savePlace(Place place);
}
