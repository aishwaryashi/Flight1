package com.demo.flight_reservation_app_10_1.service;

import com.demo.flight_reservation_app_10_1.dto.ReservationRequest;
import com.demo.flight_reservation_app_10_1.entity.Reservation;

public interface ReservationService {
	
	Reservation bookFlight(ReservationRequest request);

}
