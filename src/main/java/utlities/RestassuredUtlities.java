package utlities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import Payloads.Requestbody;
import baseclass.Basetest;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestassuredUtlities {
	 Requestbody request = new Requestbody();
	    String placeId;
	    PrintStream log;

	    public void postrequest() throws FileNotFoundException {
	        log = new PrintStream(new File("src/test/resources/logger/postlog.txt"));

	        Response response = given(Basetest.setup())
	                .filter(RequestLoggingFilter.logRequestTo(log))
	                .filter(ResponseLoggingFilter.logResponseTo(log))
	                .queryParam("key", "qaclick123")
	                .contentType("application/json")
	                .body(request.postbody())
	                .when()
	                .post(Resource.postResource.getResource())
	                .then()
	                .statusCode(200)
	                .extract().response();

	        String responseString = response.asString();
	        JsonPath js = new JsonPath(responseString);
	        placeId = js.getString("place_id");
	        System.out.println("Extracted Place ID: " + placeId);
	    }

	    public void getrequest() throws FileNotFoundException {
	        log = new PrintStream(new File("src/test/resources/logger/getlog.txt"));

	        given(Basetest.setup())
	                .filter(RequestLoggingFilter.logRequestTo(log))
	                .filter(ResponseLoggingFilter.logResponseTo(log))
	                .queryParam("key", "qaclick123")
	                .queryParam("place_id", placeId)
	                .when()
	                .get(Resource.getResource.getResource())
	                .then()
	                .statusCode(200);
	               
	    }

	    public void putrequest() throws FileNotFoundException {
	        log = new PrintStream(new File("src/test/resources/logger/putlog.txt"));

	        String newAddress = "70 Winter Walk, USA";

	        given(Basetest.setup())
	                .filter(RequestLoggingFilter.logRequestTo(log))
	                .filter(ResponseLoggingFilter.logResponseTo(log))
	                .queryParam("key", "qaclick123")
	                .contentType("application/json")
	                .body(request.putbody(placeId, newAddress))
	                .when()
	                .put(Resource.putResource.getResource())
	                .then()
	                .statusCode(200);
	               
	    }

	    public void deleteRequest() throws FileNotFoundException {
	        log = new PrintStream(new File("src/test/resources/logger/deletelog.txt"));

	        given(Basetest.setup())
	                .filter(RequestLoggingFilter.logRequestTo(log))
	                .filter(ResponseLoggingFilter.logResponseTo(log))
	                .queryParam("key", "qaclick123")
	                .contentType("application/json")
	                .body(request.deletebody(placeId))
	                .when()
	                .post(Resource.deleteResource.getResource())  // ✅ POST instead of DELETE
	                .then()
	                .statusCode(200)
	                .body("status", equalTo("OK"));
	    }
}

