package MoxieTestPackage;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import Files.DefaultHeadersParams;
//import Files.Default_Headers_Params;
import Files.JsonBody;
import Files.ReusableMethods;

import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;
//import org.junit.BeforeClass;


public class PostCreateSession {
	
	@Test
	public void statusCodeValidation()                                                   //status code validation
	{
		
	RequestSpecification Spec=ReusableMethods.getSpec();
	String response = given()
	.spec(Spec)
	
	.when()
	.post("/me/coaches/sessions")
	
	.then()
	.assertThat()
	
	.header("Content-Length","247")
	.body("duration", equalTo(60))
	.statusCode(201)
    
    .extract().response().asString();
	
	JsonPath js1=ReusableMethods.rawToJson(response);
	String CoachId =js1.getString("coachId");
	
	System.out.println(CoachId);
}
	
	
	@Test
	public void tokenValidation()                                                              //Token validation
	{
		
		RestAssured.baseURI="https://api.uat.moxiecoach.com";
		
		 given()
		 .headers(DefaultHeadersParams.tokenValidationHeaders()) //Authentication.BearerToken()
		.body(JsonBody.CreateSession())
		
		.when()
		.post("/me/coaches/sessions")
		
		.then()
		.statusCode(401)
		.assertThat().body("message", equalTo("Unauthorized"));  //error : headers cannot be null
		 
		 
	}
	

}
