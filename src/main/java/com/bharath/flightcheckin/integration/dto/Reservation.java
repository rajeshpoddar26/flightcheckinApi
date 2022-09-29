package com.bharath.flightcheckin.integration.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Reservation {

	private Boolean checkedIn;
	private int numberOfBags;
	private Passenger passenger;
	private Flight flight;
	private Date createdDate;
	private Date updatedDate;

}
