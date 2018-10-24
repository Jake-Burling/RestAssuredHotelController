package com.qa;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HotelTest {
	RequestSpecification request = RestAssured.given();

//	@Test
//	public void getMethod() {
//		Response response = request.get("http://localhost:8090/example/v1/hotels/");
//		response.then().statusCode(200);
//		response.prettyPrint();
//	}
	
//	@Test
//	public void getOneMethod() {
//		String id = "24";
//		Response response = request.get("http://localhost:8090/example/v1/hotels/" + id);
//		response.then().statusCode(200);
//		response.prettyPrint();
//	}

//	@Test
//	public void postMethod() { 									//currently on id = 25
//		request.header("Content-Type", "application/json");
//		JSONObject requestParams = new JSONObject();
//		requestParams.put("city", "Manchester");
//		requestParams.put("description", "State");
//		requestParams.put("name", "The Lowry");
//		requestParams.put("rating", 7);
//		request.body(requestParams);
//		Response response = request.post("http://localhost:8090/example/v1/hotels");
//		response.then().statusCode(201);
//		response.prettyPrint();
//	}
//
//	@Test
//	public void deleteMethod() {
//		String idToDelete = "25";
//		Response response = request.delete("http://localhost:8090/example/v1/hotels/" + idToDelete);
//		response.then().statusCode(204);
//	}

//	@Test
//	public void putMethod() { 									
//		request.header("Content-Type", "application/json");
//		String arg1 = "24";
//		Response response = request.post("http://localhost:8090/example/v1/hotels/" + arg1);
//		JSONObject requestParams = new JSONObject();
//		requestParams.replace("city", "London");
//		requestParams.replace("description", "State");
//		requestParams.replace("name", "The Mall");
//		requestParams.replace("rating", 7);
//		request.body(requestParams);
//		Response response2 = request.post("http://localhost:8090/example/v1/hotels");
//		response2.then().statusCode(201);
//		response2.prettyPrint();
//	}
}
