package br.com.zteste.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.zteste.dao.PlaceDao;
import br.com.zteste.model.Place;


@Service
public class PlaceServiceImpl implements PlaceService {
	
	@Resource
	private PlaceDao placeDao;

	@Override
	@Transactional
	public Place create(Place place) {
		Place createdPlace = place;
		return placeDao.save(createdPlace);
	}
	
	@Override
	@Transactional
	public Place findById(Double id) {
		return placeDao.findOne(id);
	}

	/*@Override
	@Transactional(rollbackFor=PlaceNotFound.class)
	public Place delete(int id) throws PlaceNotFound {
		Place deletedPlace = placeDao.findOne(id);
		
		if (deletedPlace == null)
			throw new PlaceNotFound();
		
		placeDao.delete(deletedPlace);
		return deletedPlace;
	}*/

	@Override
	@Transactional
	public List<Place> findAll() {
		return placeDao.findAll();
	}

	@Override
	public List<Place> findNearbyPlaces(Double x, Double y, Double dMax) {
		return placeDao.findNearbyPlaces(x, y, dMax);
	}

	/*@Override
	@Transactional(rollbackFor=PlaceNotFound.class)
	public Place update(Place place) throws PlaceNotFound {
		Place updatedPlace = placeDao.findOne(place.getId());
		
		if (updatedPlace == null)
			throw new PlaceNotFound();
		
		updatedPlace.setName(place.getName());
		updatedPlace.setEmplNumber(place.getEmplNumber());
		return updatedPlace;
	}*/

}
