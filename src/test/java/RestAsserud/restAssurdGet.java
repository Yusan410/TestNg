package RestAsserud;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class restAssurdGet {
	
	public static void main(String[] args) {
		
		//class 1//
		
		
		
	//https://reqres.in/api/users?page=1
		
		//set the base URL
		
		RestAssured.baseURI = "https://reqres.in/api/users?page=1";
		
		// create Request object
		
		RequestSpecification httpRequest = RestAssured.given();
		
		//respone object
		
		
		Response myResponse = httpRequest.request(Method.GET);
		
		System.out.println(myResponse.then().log().all());
		
		
		int statuscode = myResponse.getStatusCode();
		
		
		System.out.println(statuscode);
		
		Assert.assertEquals(statuscode, 200);
		
	}

}
