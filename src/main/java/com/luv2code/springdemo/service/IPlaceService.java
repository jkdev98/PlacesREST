package com.luv2code.springdemo.service;

import com.luv2code.springdemo.entity.Place;

import java.util.List;

public interface IPlaceService {
    List getPlaces();
    void savePlace(Place place);
    public Place getPlace(int id);
    public void deletePlace(int id);
}
