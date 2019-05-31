package com.luv2code.springdemo.rest;

import java.util.List;

import com.luv2code.springdemo.entity.Place;
import com.luv2code.springdemo.service.IPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PlaceRestController {

	// autowire the CustomerService
	@Autowired
	private IPlaceService restaurantService;
	
	// add mapping for GET /customers
	@GetMapping("/places")
	public List<Place> getPlaces() {
		
		return restaurantService.getPlaces();
		
	}
	
	// add mapping for GET /customers/{customerId}
	
	@GetMapping("/places/{placeId}")
	public Place getPlace(@PathVariable int placeId) {
		
		Place place = restaurantService.getPlace(placeId);
		
		if (place == null) {
			throw new PlaceNotFoundException("Customer id not found - " + placeId);
		}
		
		return place;
	}
	
	// add mapping for POST /customers  - add new customer
	
	@PostMapping("/places")
	public Place addPlace(@RequestBody Place place) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		// TODO ?????????????????????????????????
		place.setId(0);

		restaurantService.savePlace(place);
		
		return place;
	}
	
	// add mapping for PUT /customers - update existing customer
	
	@PutMapping("/places")
	public Place updatePlace(@RequestBody Place place) {

		restaurantService.savePlace(place);
		
		return place;
	}
	
	// add mapping for DELETE /customers/{customerId} - delete customer
	
	@DeleteMapping("/places/{placeId}")
	public String deleteCustomer(@PathVariable int placeId) {
		
		Place tempPlace = restaurantService.getPlace(placeId);
		
		// throw exception if null
		
		if (tempPlace == null) {
			throw new PlaceNotFoundException("Customer id not found - " + placeId);
		}

		restaurantService.deletePlace(placeId);
		
		return "Deleted customer id - " + placeId;
	}
	
}


















