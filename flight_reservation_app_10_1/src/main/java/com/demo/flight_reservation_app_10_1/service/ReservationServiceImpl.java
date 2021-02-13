package com.demo.flight_reservation_app_10_1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.flight_reservation_app_10_1.dto.ReservationRequest;
import com.demo.flight_reservation_app_10_1.entity.Flight;
import com.demo.flight_reservation_app_10_1.entity.Passenger;
import com.demo.flight_reservation_app_10_1.entity.Reservation;
import com.demo.flight_reservation_app_10_1.repository.FlightRepository;
import com.demo.flight_reservation_app_10_1.repository.PassengerRepository;
import com.demo.flight_reservation_app_10_1.repository.ReservationRepository;
import com.demo.flight_reservation_app_10_1.utilities.EmailUtil;
import com.demo.flight_reservation_app_10_1.utilities.PDFGenerator;


@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private FlightRepository  flightRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	 private PDFGenerator pdfGenerator;
	
	
	@Autowired
	private EmailUtil emailUtil;
	
      @Override  
	public Reservation bookFlight(ReservationRequest request) {
    	  
		
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
        passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
	    passenger.setPhone(request.getPhone());
	    passengerRepo.save(passenger);
	    
	    long flightId = request.getFlightId();
	    Optional<Flight> findById = flightRepo.findById(flightId);
	    Flight flight = findById.get();
	    
	    
	    Reservation reservation= new Reservation();
	   reservation.setFlight(flight);
	   reservation.setPassenger(passenger);
	   reservation.setCheckedIn(false);
	   reservation.setNumberOfBags(0);
	   
	   String filePath="C:\\Users\\Lenovo\\Documents\\workspace-spring-tool-suite-4-4.8.0.RELEASE\\flight_reservation_app_10_1\\tickets\\reservation"+reservation.getId()+".pdf";
	   reservationRepo.save(reservation);
      pdfGenerator.generateItinerary(reservation, filePath);
      emailUtil.sendItinerary(passenger.getEmail(), filePath);
	   
      return reservation;
	}

}
