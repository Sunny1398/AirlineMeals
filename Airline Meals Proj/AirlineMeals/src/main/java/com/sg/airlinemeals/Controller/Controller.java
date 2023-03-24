////This controller class was made to test the JDBC connection and functionality before changing it to HTML controller (requestController)
//
//package com.sg.airlinemeals.Controller;
//
//import com.sg.airlinemeals.DAO.requestDAODB;
//import com.sg.airlinemeals.Entities.Request;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.Scanner;
//
////Get rid of mapping
//
//@RestController
//@RequestMapping("/api")
//public class Controller {
//
//    public Controller(requestDAODB rdIn) {
//        this.rd = rdIn;
//        this.runner();
//    }
//
//    @Autowired
//    requestDAODB rd;
//
//
//    Scanner sc = new Scanner(System.in);
//
////    @GetMapping
////    public String amethod()
////    {
////        return "Hello ";
////    }
//    public void runner() {
//        do {
//            System.out.println("=== AIRLINE MEALS ===");
//            System.out.println("1. Enter Request");
//            System.out.println("2. Update Request");
//            System.out.println("3. View All Requests"); 
//            System.out.println("4. Exit");
//            System.out.println("Enter an option:");
//            String option = sc.nextLine();
//
//            try {
//                switch (option) {
//                    case "1":
//                    	this.addRequest();
//                        break;
//                    case "2":
//                        this.updateRequest();
//                        break;
//                    case "3":
//                        this.getRequests();
//                        break;
//                    case "4":
//                        System.out.println("Exiting...");
//                        System.exit(0);
//                    default:
//                        System.out.println("Invalid input: Please try again!");
//                }
//            } catch (Exception ex) {
//                System.out.println("Error communicating with database");
//                System.out.println(ex.getMessage());
//                System.out.println("Re-input ID");
//            }
//
//        } while (true);
//    }
//
//    @PostMapping("/addrequests")
//    public Request addRequest()
//    {
//    	Scanner scanner = new Scanner(System.in);
//    	System.out.println("Enter flight ID:");
//        String flight = scanner.nextLine();
//        System.out.println("Enter customer name:");
//        String name = scanner.nextLine();
//        System.out.println("Enter seat number:");
//        String seat = scanner.nextLine();
//        System.out.println("Enter meal type (non-veg/veg/vegan):");
//        String meal = scanner.nextLine();
//        System.out.println("Enter any allergies or preferences (or leave blank):");
//        String pref = scanner.nextLine();
//        
//        Request createReq = new Request();
//	    createReq.setFlightID(flight);
//	    createReq.setCustomerName(name);
//	    createReq.setSeatNumber(seat);
//	    createReq.setMealType(meal);
//	    createReq.setAllergyOrPref(pref);
//	    
//        return rd.addRequest(createReq);
//    }
//    
//    @GetMapping("/getallrequests")
//    public List<Request> getRequests()
//    {
//       return rd.getAllRequests();
//    }
//    
//    @GetMapping("/getallrequestsbyid")
//    public Request getRequestsByFlightId()
//    {
//    	Scanner s = new Scanner(System.in);
//    	System.out.println("Please Enter FLight ID: ");
//        int f_id = s.nextInt();
//    	return rd.getRequestsByFlightId(f_id);
//    }
//    
//    @PostMapping("/updaterequests")
//    public void updateRequest()
//    {
//    	Scanner scan = new Scanner(System.in);
//    	System.out.println("Enter flight ID:");
//        String flight = scan.nextLine();
//        System.out.println("Enter customer name:");
//        String name = scan.nextLine();
//        System.out.println("Enter seat number:");
//        String seat = scan.nextLine();
//        System.out.println("Enter meal type (non-veg/veg/vegan):");
//        String meal = scan.nextLine();
//        System.out.println("Enter any allergies or preferences (or leave blank):");
//        String pref = scan.nextLine();
//        System.out.println("What is your Request ID number?");
//        int id = scan.nextInt();
//        
//        Request updateReq = new Request();
//	    updateReq.setFlightID(flight);
//	    updateReq.setCustomerName(name);
//	    updateReq.setSeatNumber(seat);
//	    updateReq.setMealType(meal);
//	    updateReq.setAllergyOrPref(pref);
//	    updateReq.setId(id);
//	    
//        rd.updateRequest(updateReq);
//    }
//}
