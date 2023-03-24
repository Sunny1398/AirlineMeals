package com.sg.airlinemeals.DAO;

import java.util.List;

import com.sg.airlinemeals.Entities.Request;

public interface requestDAO {
    
    Request getRequestsByFlightId(int id);
    List<Request> getAllRequests();
    Request addRequest(Request request);
    void updateRequest(Request request);
	Request getRequestById(int id);

}
