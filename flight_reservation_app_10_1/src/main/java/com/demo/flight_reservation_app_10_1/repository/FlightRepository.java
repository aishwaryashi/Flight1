package com.demo.flight_reservation_app_10_1.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.flight_reservation_app_10_1.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
   
	
	@Query("From Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:departureDate")
	List<Flight> findFlight(@Param("departureCity") String from, @Param("arrivalCity") String to , @Param("departureDate") Date departureDate);

}
