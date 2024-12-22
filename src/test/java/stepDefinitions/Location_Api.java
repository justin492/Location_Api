package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.utils;

public class Location_Api extends utils {

	RequestSpecification req;
	ResponseSpecification res;
	Response response;
	TestDataBuild data;
	@Given("Add place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String Address) throws IOException {
		data=new TestDataBuild();
		
		req=given().spec(requestSpecification()).
				body(data.addPlacePayLoad(name, language, Address));	
		
	}

	@When("The user calls {string} with Post http request")
	public void the_user_calls_with_post_http_request(String string) {
		
		res=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 response=req.when().post("maps/api/place/add/json").then().
				spec(res).extract().response();
		 
	}

	@Then("The API call get success with Status code {int}")
	public void the_api_call_get_success_with_status_code(Integer int1) {
	   assertEquals(response.getStatusCode(), int1); 
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String Keyvalue, String expValue) {
	    String resp=response.asString();
	    JsonPath js=new JsonPath(resp);
	    assertEquals(js.get(Keyvalue).toString(),expValue );
	}
}
