package com.bharath.flightcheckin.integration.dto;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class Flight {
	
	private String flightNumber;
	private String operationalAirlines;
	private String departureCity;
	private String arrivalCity;
	private Date dateOfDeparture;
	private Timestamp estimatedDepartureTime;
	

}
