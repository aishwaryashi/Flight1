package com.demo.flight_reservation_app_10_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.flight_reservation_app_10_1.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
