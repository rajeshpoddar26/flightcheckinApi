package com.bharath.flightcheckin.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bharath.flightcheckin.integration.dto.Reservation;
import com.bharath.flightcheckin.integration.dto.ReservationUpdateRequest;

@Service
public class ReservationRestClientImpl implements ReservationRestClient {
	
	@Value("${com.bharath.flightcheckin.itinerary.reservationUrl}")
	private String RESERVATION_REST_URL;
	@Value("${com.bharath.flightcheckin.itinerary.reservationUpdateUrl}")
	private String RESERVATION_REST_UPDATE_URL;
	
	
	@Override
	public Reservation findReservation(Long id) {

		RestTemplate restTemplate= new RestTemplate();
		Reservation reservation= restTemplate.getForObject(RESERVATION_REST_URL+id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {

		RestTemplate restTemplate= new RestTemplate();
		Reservation reservation=restTemplate.postForObject(RESERVATION_REST_UPDATE_URL, request, Reservation.class);
		
		return reservation;
	}

	@Override
	public String completeCheckin(Long reservationId, int numberOfbags) {
		
		ReservationUpdateRequest updateRequest= new ReservationUpdateRequest();
		updateRequest.setId(reservationId);
		updateRequest.setNumberOfBags(numberOfbags);
		updateRequest.setCheckedIn(true);
		updateReservation(updateRequest);
		
		return "chekedIn sussfull";
	}

}
