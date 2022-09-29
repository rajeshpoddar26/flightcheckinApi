package com.bharath.flightcheckin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.flightcheckin.integration.ReservationRestClient;
import com.bharath.flightcheckin.integration.dto.Reservation;
import com.bharath.flightcheckin.integration.dto.ReservationUpdateRequest;

@RestController
@RequestMapping("/api/v1/checkIn")
public class CheckInController {

	@Autowired
	private ReservationRestClient reservationRestClient;

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}
	
	@GetMapping("/showStartCheckIn")
	public Object startCheckIn(@RequestParam("reservationId") Long reservationId) {

		Reservation reservation = reservationRestClient.findReservation(reservationId);
		return reservation;
	}

	@PostMapping("/completeCheckIn")
	public String completeCheckin(@RequestParam("reservationId") Long reservationId, @RequestParam ("numberOfbags") int numberOfbags) {

		return reservationRestClient.completeCheckin(reservationId, numberOfbags);
	}

}
