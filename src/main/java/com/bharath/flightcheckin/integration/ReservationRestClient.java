package com.bharath.flightcheckin.integration;

import com.bharath.flightcheckin.integration.dto.Reservation;
import com.bharath.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	Reservation findReservation(Long id);

	Reservation updateReservation(ReservationUpdateRequest request);

	String completeCheckin(Long reservationId, int numberOfbags);

}
