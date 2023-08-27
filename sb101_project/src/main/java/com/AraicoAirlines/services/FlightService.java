package com.AraicoAirlines.services;

import com.AraicoAirlines.dao.FlightDAO;
import com.AraicoAirlines.dto.Flight;
import com.AraicoAirlines.exceptions.SomethingWentWrongException;

public class FlightService {
    private final FlightDAO flightDAO;

    public FlightService(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    public void addFlight(Flight flight) throws SomethingWentWrongException {
        try {
            flightDAO.addFlight(flight);
        } catch (SomethingWentWrongException e) {
            throw e;
        }
    }


    public void updateFlight(Flight flight) throws SomethingWentWrongException {
        try {
            flightDAO.updateFlight(flight);
        } catch (Exception e) {
            throw new SomethingWentWrongException("Error updating flight");
        }
    }

    public void removeFlight(String flightNumber) throws SomethingWentWrongException {
        try {
            flightDAO.removeFlight(flightNumber);
        } catch (Exception e) {
            throw new SomethingWentWrongException("Error removing flight");
        }
    }
}
