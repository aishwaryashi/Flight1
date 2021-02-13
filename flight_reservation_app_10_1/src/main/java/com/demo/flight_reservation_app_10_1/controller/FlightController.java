package com.demo.flight_reservation_app_10_1.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.flight_reservation_app_10_1.entity.Flight;
import com.demo.flight_reservation_app_10_1.repository.FlightRepository;

@Controller
public class FlightController {
	
	
	@Autowired
	private FlightRepository flightRepo;	
	
	@RequestMapping("/findflight")
	public String findFlight(@RequestParam("from") String from , @RequestParam("to") String to , @RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate , ModelMap modelMap) { 
	List<Flight> findFlight = flightRepo.findFlight(from, to, departureDate);
    System.out.println(findFlight);
    modelMap.addAttribute("findFlight", findFlight);
    return"login/displayFlight";
	}

	@RequestMapping("showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId , ModelMap modelMap) {
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		modelMap.addAttribute("flight",flight);
        return"showReservation";
		
	}
	
}
