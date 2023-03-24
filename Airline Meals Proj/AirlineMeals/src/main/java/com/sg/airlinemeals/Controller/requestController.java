package com.sg.airlinemeals.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.sg.airlinemeals.DAO.requestDAODB;
import com.sg.airlinemeals.Entities.Request;

@Controller
public class requestController {
	
    public requestController(requestDAODB rdIn) {
        this.rd = rdIn;
       // this.runner();
    }

    @Autowired
    requestDAODB rd;
    
    @GetMapping("requests")
    public String displayRequests(Model model) {
        List<Request> request = rd.getAllRequests();
        model.addAttribute("requests", request);
        return "requests";
    }
    
    @PostMapping("addRequest")
    public String addRequest(HttpServletRequest request) {
        String flightId = request.getParameter("flight_id");
        String customerName = request.getParameter("customer_name");
        String seatNumber = request.getParameter("seat_number");
        String mealType = request.getParameter("meal_type");
        String allergyPref = request.getParameter("allergy_or_pref");
        
        Request r = new Request();
        r.setFlightID(flightId);
        r.setCustomerName(customerName);
        r.setSeatNumber(seatNumber);
        r.setMealType(mealType);
        r.setAllergyOrPref(allergyPref);
        
        rd.addRequest(r);
        
        return "redirect:/Passanger.html";
    }
    
    @GetMapping("editRequest")
    public String editRequest(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Request er = rd.getRequestById(id);
        
        model.addAttribute("teacher", er);
        return "editRequest";
    }
    
    @PostMapping("editRequest")
    public String performEditRequest(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Request req = rd.getRequestById(id);
        
        req.setFlightID(request.getParameter("flight_id"));
        req.setCustomerName(request.getParameter("customer_name"));
        req.setSeatNumber(request.getParameter("seat_number"));
        req.setMealType(request.getParameter("meal_type"));
        req.setAllergyOrPref(request.getParameter("allergy_or_pref"));
        
        rd.updateRequest(req);
        
        return "redirect:/Passanger.html";
    }

}
