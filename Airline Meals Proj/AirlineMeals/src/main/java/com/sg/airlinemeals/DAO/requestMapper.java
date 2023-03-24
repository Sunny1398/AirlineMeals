package com.sg.airlinemeals.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sg.airlinemeals.Entities.Request;

public final class requestMapper implements RowMapper<Request> {

    @Override
    public Request mapRow(ResultSet rs, int index) throws SQLException {
        Request request = new Request();
        request.setId(rs.getInt("id"));
        request.setFlightID(rs.getString("flight_id"));
        request.setCustomerName(rs.getString("customer_name"));
        request.setSeatNumber(rs.getString("seat_number"));
        request.setMealType(rs.getString("meal_type"));
        request.setAllergyOrPref(rs.getString("allergy_or_pref"));
        
        return request;
    }
}
