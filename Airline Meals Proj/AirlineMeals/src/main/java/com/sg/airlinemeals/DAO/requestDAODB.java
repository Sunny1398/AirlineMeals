package com.sg.airlinemeals.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sg.airlinemeals.Entities.Request;

@Repository
public class requestDAODB implements requestDAO{

   @Autowired
   JdbcTemplate jdbc;

    public requestDAODB(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
   public Request getRequestsByFlightId(int id) {
       try {
           final String GET_REQUEST_BY_FID = "SELECT * FROM requests WHERE flight_id = ?";
           Request requestByFlightId =  jdbc.queryForObject(GET_REQUEST_BY_FID, new requestMapper(), id);
           return requestByFlightId;
       } catch(DataAccessException ex) {
           return null;
       }
   }
    
    @Override
    public Request getRequestById(int id) {
        try {
            final String GET_REQUEST_BY_ID = "SELECT * FROM requests WHERE id = ?";
            Request requestById =  jdbc.queryForObject(GET_REQUEST_BY_ID, new requestMapper(), id);
            return requestById;
        } catch(DataAccessException ex) {
            return null;
        }
    }

   @Override
   public List<Request> getAllRequests() {
       final String GET_ALL_REQUESTS = "SELECT * FROM requests";
        List<Request> allRequests = jdbc.query(GET_ALL_REQUESTS, new requestMapper());
       for (Request oneRequest: allRequests) {
           System.out.println(oneRequest.toString());
       }
       return allRequests;
   }

   @Override
   @Transactional
   public Request addRequest(Request request) {
       final String INSERT_GAME = "INSERT INTO requests(flight_id, customer_name, seat_number, meal_type, allergy_or_pref) " +
               "VALUES(?,?,?,?,?)";
       jdbc.update(INSERT_GAME,
               request.getFlightID(),
               request.getCustomerName(),
               request.getSeatNumber(),
               request.getMealType(),
               request.getAllergyOrPref());
       
       int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
       request.setId(newId);
       return request;
   }

   @Override
   public void updateRequest(Request request) {
       final String UPDATE_REQUEST = "UPDATE requests SET flight_id = ?, customer_name = ?, " +
               "seat_number = ?, meal_type = ?, allergy_or_pref = ? WHERE id = ?";
       jdbc.update(UPDATE_REQUEST,
               request.getFlightID(),
               request.getCustomerName(),
               request.getSeatNumber(),
               request.getAllergyOrPref(),
               request.getMealType(),
               request.getId());
   }
}
