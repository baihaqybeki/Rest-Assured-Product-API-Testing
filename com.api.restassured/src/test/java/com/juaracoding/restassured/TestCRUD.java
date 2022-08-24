package com.juaracoding.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestCRUD {
	
	@Test
	public void testPost() {
		JSONObject request = new JSONObject();
		request.put("name", "Laptop");
		request.put("category", "Elektronik");
		request.put("price", "1000000");
		System.out.println(request.toJSONString());
		
		given()
		.header("content-type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("https://mern-backend-8881.herokuapp.com/products")
		.then()
		.statusCode(200)
		.log().all();

	}
}
