package com.example.demo0914;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@SpringBootTest
class Demo0914ApplicationTests {

	@Test
	void contextLoads() {
		RestAssured.baseURI="https://dog.ceo/api/breeds/list/all";
		RestAssured.given().log().all()
			.when().get()
			.then().log().all()
			.assertThat()
			.statusCode(200);

	}
	
	@Test
	void isServerCloud() {
		RestAssured.baseURI="https://dog.ceo/api/breeds/list/all";
		RestAssured.given().log().all()
			.when().get()
			.then().log().all()
			.assertThat()
			.statusCode(200)
			.header("Server", "cloudflare");
	}
	
	@Test
	void payloadDataResponse() {
		RestAssured.baseURI="https://dog.ceo/api/breeds/list/all";
		Response httpResponse = RestAssured.given().log().all()
			.when().get()
			.then().log().all()
			.assertThat()
			.statusCode(200)
			.extract().response();
		
		JsonPath jsonPath = new JsonPath(httpResponse.toString());
		System.out.println(jsonPath.toString());
	}

}
