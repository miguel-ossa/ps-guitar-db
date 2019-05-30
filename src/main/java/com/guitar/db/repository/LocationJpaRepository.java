package com.guitar.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guitar.db.model.Location;

@Repository
public interface LocationJpaRepository extends JpaRepository<Location, Long> {

	List<Location> findByStateLike(String stateName);
	List<Location> findByStateStartingWith(String stateName);
	List<Location> findByStateIgnoreCaseStartingWith(String stateName);
	Location       findFirstByStateIgnoreCaseStartingWith(String stateName);
	List<Location> findByStateNotLike(String stateName);
	List<Location> findByStateNotLikeOrderByStateAsc(String stateName);
	
	// find all locations by state or country
	List<Location> findByStateOrCountry(String state, String country);
	List<Location> findByStateIsOrCountryEquals(String state, String country);
	
	// find all locations by state and country
	List<Location> findByStateAndCountry(String state, String country);
	
	// find all locations not equals the state used
	List<Location> findByStateNot(String state);
}
