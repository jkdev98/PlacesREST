package com.jkdev.springREST.dao;

import com.jkdev.springREST.entity.Opinion;
import com.jkdev.springREST.entity.Place;
import com.jkdev.springREST.rest.PlaceNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaceDAOImpl implements IPlaceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Place> getPlaces() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Place> placeQuery = currentSession.createQuery("from Place order by name", Place.class);

        return placeQuery.getResultList();
    }

    @Override
    public Place getPlace(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.get(Place.class, theId);
    }

    @Override
    public void deletePlace(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        if (currentSession.get(Place.class, theId) == null) {
            throw new PlaceNotFoundException("Place id not found - " + theId);
        }
        currentSession.delete(currentSession.get(Place.class, theId));
    }

    @Override
    public void savePlace(Place place) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(place);

    }

    @Override
    public void updatePlace(Place place) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.update(place);
    }

    @Override
    public void addOpinionByPlaceId(int id, Opinion opinion) {
        Session currentSession = sessionFactory.getCurrentSession();
        Place tempPlace = currentSession.get(Place.class, id);
        tempPlace.addOpinion(opinion);
        currentSession.saveOrUpdate(tempPlace);

    }

    @Override
    public List<Opinion> getOpinions(int placeId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Opinion> opinionQuery = currentSession.createQuery("from Opinion where places_id=: placeId", Opinion.class);
        opinionQuery.setParameter("placeId", placeId);

        return opinionQuery.getResultList();
    }

    @Override
    public void removeOpinionByPlaceId(int placeId, int opinionId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Place tempPlace = currentSession.get(Place.class, placeId);
        Opinion opinion = currentSession.get(Opinion.class, opinionId);
        tempPlace.removeOpinion(opinion);
        currentSession.remove(opinion);
        currentSession.saveOrUpdate(tempPlace);

    }

    @Override
    public void updateOpinionByPlaceId(int placeId, int opinionId, Opinion opinion) {
        Session currentSession = sessionFactory.getCurrentSession();
        Place tempPlace = currentSession.get(Place.class, placeId);
        Opinion tempOpinion = currentSession.get(Opinion.class, opinionId);
        tempPlace.removeOpinion(tempOpinion);
        tempOpinion.setRate(opinion.getRate());
        tempOpinion.setComment(opinion.getComment());
        tempPlace.addOpinion(tempOpinion);
        currentSession.update(tempPlace);
        currentSession.update(tempOpinion);
    }
}
