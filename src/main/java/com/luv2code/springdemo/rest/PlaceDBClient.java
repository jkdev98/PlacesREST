package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Place;
import com.luv2code.springdemo.service.IPlaceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

public class PlaceDBClient implements IPlaceService {

    private RestTemplate restTemplate;
    private String crmRestURL;

    private Logger logger = Logger.getLogger(getClass().getName());

    public PlaceDBClient(RestTemplate restTemplate, @Value("${crm.rest.url}") String crmRestURL) {
        this.restTemplate = restTemplate;
        this.crmRestURL = crmRestURL;
    }

    @Override
    public List getPlaces() {
        ResponseEntity<List<Place>> responseEntity = restTemplate.exchange(crmRestURL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Place>>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public void savePlace(Place place) {
        //int placeId =
    }

    @Override
    public Place getPlace(int id) {

        return restTemplate.getForObject(crmRestURL + "/" + id, Place.class);
    }

    @Override
    public void deletePlace(int id) {

    }
}
