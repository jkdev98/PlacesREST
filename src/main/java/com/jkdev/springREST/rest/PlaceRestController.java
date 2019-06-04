package com.jkdev.springREST.rest;

import java.util.List;

import com.jkdev.springREST.entity.Opinion;
import com.jkdev.springREST.entity.Place;
import com.jkdev.springREST.service.IPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PlaceRestController {

    @Autowired
    private IPlaceService placeService;

    @PostMapping("places/{placeId}/opinions")
    public Opinion addOpinion(@RequestBody Opinion opinion, @PathVariable int placeId) {
        placeService.addOpinionToPlace(placeId, opinion);

        return opinion;
    }

    @DeleteMapping("places/{placeId}/opinions/{opinionId}")
    public String removeOpinion(@PathVariable int placeId, @PathVariable int opinionId) {
        Place place = placeService.getPlace(placeId);

        if (place == null) {
            throw new PlaceNotFoundException("Place id not found - " + placeId);
        } else
            for (Opinion tempOpinion : placeService.getOpinionsByPlaceId(placeId)) {
                if (tempOpinion.getId() == opinionId) {
                    placeService.removeOpinionByPlaceId(placeId, opinionId);
                    return "Opinion with id: " + opinionId + " deleted successfully";
                }
            }

        throw new OpinionNotFoundException("Opinion with id " + opinionId + " not found!");
    }

    @GetMapping("places/{placeId}/opinions")
    public List<Opinion> getOpinionsByPlaceId(@PathVariable int placeId) {
        return placeService.getOpinionsByPlaceId(placeId);
    }

    @GetMapping("places/{placeId}/opinions/{opinionId}")
    public Opinion getOpinionById(@PathVariable int placeId, @PathVariable int opinionId) {
        Place place = placeService.getPlace(placeId);

        if (place == null) {
            throw new PlaceNotFoundException("Place id not found - " + placeId);
        } else
            for (Opinion tempOpinion : placeService.getOpinionsByPlaceId(placeId)) {
                if (tempOpinion.getId() == opinionId) {
                    return tempOpinion;
                }
            }
        throw new OpinionNotFoundException("Opinion with id " + opinionId + " not found!");
    }

    @PutMapping("places/{placeId}/opinions/{opinionId}")
    public String updateOpinion(@RequestBody Opinion opinion, @PathVariable int placeId, @PathVariable int opinionId) {
        Place place = placeService.getPlace(placeId);

        if (place == null) {
            throw new PlaceNotFoundException("Place id not found - " + placeId);
        } else
            for (Opinion tempOpinion : placeService.getOpinionsByPlaceId(placeId)) {
                if (tempOpinion.getId() == opinionId) {
                    placeService.updateOpinionByPlaceId(placeId, opinionId, opinion);
                    return "Opinion with id: " + opinionId + " updated successfully";
                }
            }


        throw new OpinionNotFoundException("Opinion with id " + opinionId + " not found!");
    }

    @GetMapping("/places")
    public List<Place> getPlaces() {

        return placeService.getPlaces();

    }

    @GetMapping("/places/{placeId}")
    public Place getPlace(@PathVariable int placeId) {

        Place place = placeService.getPlace(placeId);

        if (place == null) {
            throw new PlaceNotFoundException("Place id not found - " + placeId);
        }

        return place;
    }

    @PostMapping("/places")
    public Place addPlace(@RequestBody Place place) {
        for (Place servicePlace : placeService.getPlaces()) {
            if (place.getName().equals(servicePlace.getName())) {
                throw new PlaceAlreadyAddedException("Place is already in service!");
            }
        }
        place.setId(0);

        placeService.savePlace(place);

        return place;
    }

    @PutMapping("/places")
    public Place updatePlace(@RequestBody Place place) {

        //TODO make update instead of savePlace
        placeService.updatePlace(place);

        return place;
    }

    @DeleteMapping("/places/{placeId}")
    public String deletePlace(@PathVariable int placeId) {

        placeService.deletePlace(placeId);

        return "Deleted customer id - " + placeId;
    }

}


















