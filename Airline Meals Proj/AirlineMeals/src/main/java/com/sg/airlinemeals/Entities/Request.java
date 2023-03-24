package com.sg.airlinemeals.Entities;

public class Request {
	
	private int id;
	private String flightID;
	private String customerName;
    private String seatNumber;
    private String mealType;
    private String AllergyOrPref;

	public Request() {
	}


    public String getFlightID() {
		return flightID;
	}

	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getSeatNumber() {
		return seatNumber;
	}


	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}


	public String getAllergyOrPref() {
		return AllergyOrPref;
	}


	public void setAllergyOrPref(String allergyOrPref) {
		AllergyOrPref = allergyOrPref;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public String getMealType() {
		return mealType;
	}


	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	
	@Override
	public String toString() {
		return "Request{" +
				"request id = " + id +
				", flight id = " + flightID +
				", customer name = " + customerName +
				", seat number ='" + seatNumber + '\'' +
				", allgery/prefrence =" + AllergyOrPref +
				'}';
	}
}
