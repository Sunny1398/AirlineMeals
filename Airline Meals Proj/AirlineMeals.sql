DROP DATABASE IF EXISTS AirlineMeals; -- Drops the existing database, if it exists

CREATE DATABASE AirlineMeals; -- Create database named HotelDB

USE AirlineMeals;

CREATE TABLE requests (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  flight_id VARCHAR(10) NOT NULL,
  customer_name VARCHAR(50) NOT NULL,
  seat_number VARCHAR(10) NOT NULL,
  meal_type VARCHAR(10) NOT NULL,
  allergy_or_pref VARCHAR(255)
);