package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Place;
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

        Query placeQuery = currentSession.createQuery("delete from Place where id=:placeId");
        placeQuery.setParameter("placeId", theId);
    }

    @Override
    public void savePlace(Place place) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(place);

    }
}
