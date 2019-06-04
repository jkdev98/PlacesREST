package com.jkdev.springREST.service;

import com.jkdev.springREST.entity.Opinion;
import com.jkdev.springREST.dao.IPlaceDAO;
import com.jkdev.springREST.entity.Place;
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
    public List<Place> getPlaces() {
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

    @Override
    public void updatePlace(Place place) {
        placeDAO.updatePlace(place);
    }

    @Override
    public void addOpinionToPlace(int id, Opinion opinion) {
        placeDAO.addOpinionByPlaceId(id, opinion);
    }

    @Override
    public void removeOpinionByPlaceId(int id, int opinionId) {
        placeDAO.removeOpinionByPlaceId(id, opinionId);
    }

    @Override
    public List<Opinion> getOpinionsByPlaceId(int id) {
        return placeDAO.getOpinions(id);
    }

    @Override
    public void updateOpinionByPlaceId(int placeId, int opinionId, Opinion opinion) {
        placeDAO.updateOpinionByPlaceId(placeId, opinionId, opinion);
    }
}
