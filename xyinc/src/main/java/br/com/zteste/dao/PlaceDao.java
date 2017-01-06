/**
 * 
 */
/**
 * @author arthur
 *
 */
package br.com.zteste.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.zteste.model.Place;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlaceDao extends JpaRepository<Place, Double> {
	
	@Query("SELECT p FROM Place p WHERE SQRT((p.x-:x)*(p.x-:x)+(p.y-:y)*(p.y-:y)) <= :dMax")
    public List<Place> findNearbyPlaces(@Param("x") Double x,
    		@Param("y") Double y, @Param("dMax") Double dMax);

}