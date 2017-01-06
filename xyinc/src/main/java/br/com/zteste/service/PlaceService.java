package br.com.zteste.service;

import java.util.List;

import br.com.zteste.model.Place;

public interface PlaceService {
    
    public Place create(Place shop);
    /*public Place delete(int id) throws PlaceNotFound;*/
    public List<Place> findAll();
    /*public Place update(Place shop) throws PlaceNotFound;*/
    public Place findById(Double id);
    public List<Place> findNearbyPlaces(Double x, Double y, Double dMax);
 
}