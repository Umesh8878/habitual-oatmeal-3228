package com.AraicoAirlines.dao;

import com.AraicoAirlines.dto.Flight;
import com.AraicoAirlines.utility.DBUtils;
import com.AraicoAirlines.exceptions.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class FlightDAOImpl implements FlightDAO {
	@Override
	public void addFlight(Flight flight) throws SomethingWentWrongException {
	    EntityManager entityManager = DBUtils.getEntityManager();
	    EntityTransaction transaction = entityManager.getTransaction();

	    try {
	        transaction.begin();
	        entityManager.persist(flight);
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null && transaction.isActive()) {
	            transaction.rollback();
	        }
	        throw new SomethingWentWrongException("Error adding flight");
	    } finally {
	        entityManager.close();
	    }
	}


    @Override
    public void updateFlight(Flight flight) {
        EntityManager entityManager = DBUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(flight);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void removeFlight(String flightNumber) {
        EntityManager entityManager = DBUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Flight flight = entityManager.find(Flight.class, flightNumber);
            if (flight != null) {
                entityManager.remove(flight);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

	@Override
	public Flight getFlightByNumber(String flightNumber) {
		return null;
	}
}
