package utlities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileNotFoundException;

import baseclass.Basetest;


public class ValidationUtlties {
	

	    public void statuscodeValidation() throws FileNotFoundException {
	        given()
	            .spec(Basetest.setup())
	        .when()
	             .then()
	        .statusCode(200)
	            .spec(Basetest.responseSpec());
	    }

	    public void headerValidation() throws FileNotFoundException {
	        given()
	            .spec(Basetest.setup()) 
	        .when()
	            .get(Resource.getResource.getResource())
	        .then()
	            .statusCode(200)
	            .header("content-type", equalTo("application/json; charset=UTF-8"));
	    }

	    public void ResponseBodyValidation() throws FileNotFoundException {
	        given()
	            .spec(Basetest.setup()) 
	        .when()
	            .get(Resource.getResource.getResource())
	        .then()
	            .statusCode(200)
	            .header("Content-Type", equalTo("application/json; charset=utf-8"))
	            .body("title", equalTo("Testing"))
	            .body("body", equalTo("Rest assured"));
	    }
	}


