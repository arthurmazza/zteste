/**
 * 
 */
/**
 * @author arthur
 *
 */
package br.com.zteste.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zteste.model.Place;
import br.com.zteste.service.PlaceService;
import br.com.zteste.validation.PlaceValidator;


@RestController
@RequestMapping(value="/place")
public class PlaceRestController {

	
	@Autowired
	private PlaceService placeService;
	
	@Autowired
	private PlaceValidator placeValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(placeValidator);
	}
	
	@GetMapping("/findAll")
	public List getPlaces() {
		
		List<Place> placeList = placeService.findAll();
		
		return placeList;
	}
	
	@GetMapping("/findNearbyPlaces/{x}/{y}/{dMax}")
	public ResponseEntity getNearbyPlaces(@PathVariable("x") Double x, @PathVariable("y") Double y, @PathVariable("dMax") Double dMax){
		
		List<Place> placeList = null;
		
		if(x >= 0 && x != null && y >= 0 && y != null && dMax >= 0 && dMax != null){
			placeList = placeService.findNearbyPlaces(x, y, dMax);
		}
		else{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity(placeList, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity createPlace(@Valid @RequestBody Place place) {

		placeService.create(place);

		return new ResponseEntity(place, HttpStatus.OK);
	}

	/*@GetMapping("/places/{id}")
	public ResponseEntity getPlace(@PathVariable("id") Long id) {

		Place place = placeDAO.get(id);
		if (place == null) {
			return new ResponseEntity("No Place found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(place, HttpStatus.OK);
	}*/

	/*@DeleteMapping("/places/{id}")
	public ResponseEntity deletePlace(@PathVariable Long id) {

		if (null == placeDAO.delete(id)) {
			return new ResponseEntity("No Place found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}*/

	/*@PutMapping("/places/{id}")
	public ResponseEntity updatePlace(@PathVariable Long id, @RequestBody Place place) {

		place = placeDAO.update(id, place);

		if (null == place) {
			return new ResponseEntity("No Place found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(place, HttpStatus.OK);
	}*/

}