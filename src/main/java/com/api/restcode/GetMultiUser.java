package com.api.restcode;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetMultiUser {

	@Test
	public void Test1() {
		RestAssured.baseURI = "http://api.openweathermap.org";
		Response res = given().param("q", "London,UK").param("units", "metric")
				.param("APPID", "d75f1caf847ab9562c7bf459fe5f5a01").when().get("/data/2.5/weather").then().assertThat()
				.statusCode(200).and().contentType(ContentType.JSON).extract().response();

		String response = res.asString();
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		Number max = js.get("main.temp_max");
		Number min = js.get("main.temp_min");
		String name=js.get("name");
		System.out.println("maximum temperature in " + name+ " is " + max);
		System.out.println("minimum temperature in " + name+ " is " + min);
	}

	@Test
	public void Test2() {
		RestAssured.baseURI = "http://api.openweathermap.org";
		Response res = given().param("id", "5368361").param("units", "metric")
				.param("APPID", "d75f1caf847ab9562c7bf459fe5f5a01").when().get("/data/2.5/weather").then().assertThat()
				.statusCode(200).and().contentType(ContentType.JSON).extract().response();

		String response = res.asString();
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		Number max = js.get("main.temp_max");
		Number min = js.get("main.temp_min");
		String name=js.get("name");
		System.out.println("maximum temperature in " + name+ " is " + max);
		System.out.println("minimum temperature in " + name+ " is " + min);
	}
	
	@Test
	public void Test3() {
		RestAssured.baseURI = "http://api.openweathermap.org";
		Response res = given().
		param("id", "524901,703448,2643743").
		param("units", "metric").
		param("APPID", "d75f1caf847ab9562c7bf459fe5f5a01").
		when().get("/data/2.5/group").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
		String response = res.asString();
		System.out.println(response);		
		JsonPath js = new JsonPath(response);
		ArrayList max = js.get("list.main.temp_max");
		ArrayList min = js.get("list.main.temp_min");
		ArrayList name=js.get("list.name");
		System.out.println("maximum temperature in " + name+ " is " + max+ " respectively");
		System.out.println("minimum temperature in " + name+ " is " + min + " respectively");	
		
	}	
}
