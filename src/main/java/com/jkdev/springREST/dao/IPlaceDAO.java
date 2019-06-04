package com.jkdev.springREST.dao;

import com.jkdev.springREST.entity.Opinion;
import com.jkdev.springREST.entity.Place;

import java.util.List;

public interface IPlaceDAO {

    List<Place> getPlaces();

    Place getPlace(int theId);

    void deletePlace(int theId);

    void savePlace(Place place);

    void updatePlace(Place place);

    void addOpinionByPlaceId(int id, Opinion opinion);

    List<Opinion> getOpinions(int placeId);

    void removeOpinionByPlaceId(int placeId, int opinionId);

    void updateOpinionByPlaceId(int placeId, int opinionId, Opinion opinion);
}
