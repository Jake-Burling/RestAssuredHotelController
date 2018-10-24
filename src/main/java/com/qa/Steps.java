package com.qa;

import org.json.simple.JSONObject;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Steps {
	RequestSpecification request = RestAssured.given();
	String id = "3";
	
	@After
	public void teardown() {
		System.out.println("********************************************************");
		System.out.println("After Test");
		Response hotelList = request.get("http://localhost:8090/example/v1/hotels/");
		hotelList.prettyPrint();
		System.out.println("********************************************************");
	}
	
	@Given("^a hotel list exists that returns a status code (\\d+)$")
	public void a_hotel_list_exists_that_returns_a_status_code(int arg1) {
		System.out.println("GIVEN*******************************************************");
	    Response hotelList = request.get("http://localhost:8090/example/v1/hotels/");
		hotelList.then().statusCode(arg1);
		hotelList.prettyPrint();
		System.out.println("GIVEN*******************************************************");
	}

	@SuppressWarnings("unchecked")
	@When("^a hotel is created and posted to the site$")
	public void a_hotel_is_created_and_posted_to_the_site() {
		System.out.println("FIRST WHEN*******************************************************");
		request.header("Content-Type", "application/json");
		JSONObject requestParams = new JSONObject();
		requestParams.put("city", "Manchester");
		requestParams.put("description", "State");
		requestParams.put("name", "The Lowry");
		requestParams.put("rating", 7);
		request.body(requestParams);
		Response hotelList = request.post("http://localhost:8090/example/v1/hotels/");
		hotelList.then().statusCode(201);
		hotelList.prettyPrint();
		System.out.println("FIRST WHEN*******************************************************");
	}

	@SuppressWarnings("unchecked")
	@When("^the same hotel is then updated$")
	public void the_same_hotel_is_then_updated() { //I Believe the update doesn't happen!!!!
		System.out.println("SECOND WHEN*******************************************************");
		Response updateHotel = request.get("http://localhost:8090/example/v1/hotels/" + id);
		request.header("Content-Type","application/json");
		JSONObject requestParams = new JSONObject();
		requestParams.replace("city", "London");
		requestParams.replace("description", "State");
		requestParams.replace("name", "The Lowry");
		requestParams.replace("rating", 8);
		request.body(requestParams);
		Response hotelList = request.get("http://localhost:8090/example/v1/hotels/");
		hotelList.then().statusCode(200);
		hotelList.prettyPrint();
		System.out.println("SECOND WHEN*******************************************************");
	}

	@When("^the same hotel is then deleted$")
	public void the_same_hotel_is_then_deleted() {
		System.out.println("THIRD WHEN*******************************************************");
		System.out.println("Set to delete id: " + id);
	    Response response = request.delete("http://localhost:8090/example/v1/hotels/" + id);
		response.then().statusCode(204);
		System.out.println("Deleted id: " + id);
		System.out.println("THIRD WHEN*******************************************************");
	}

	@Then("^searching for that hotel will return status code (\\d+)$")
	public void searching_for_that_hotel_will_return_status_code(int arg1) {
		System.out.println("THEN*******************************************************");
		Response hotelList = request.get("http://localhost:8090/example/v1/hotels/" + id);
		hotelList.then().statusCode(arg1);
		hotelList.prettyPrint();
		System.out.println("THEN*******************************************************");
	}
}
