package MoxieTestPackage;
import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

import Files.DefaultHeadersParams;
import Files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class GetAvailability {

	@Test 
	public void listOfSlots()
	{
		
		RequestSpecification Spec1=ReusableMethods.getAvailability();
		
			String response = given()
			.spec(Spec1)
					
			.when()
			.get("https://api.uat.moxiecoach.com/me/availability")
			
			.then()
			.log().all()
			.assertThat().statusCode(200)
			.extract().response().asString();
			
			System.out.println(response);
			
			//To get the size of slots 
			JsonPath js1=ReusableMethods.rawToJson(response);
			
			
			int array=js1.getInt("array.size()");
			System.out.println(array);	
			
			for(int i=0;i<array;i++)
			{
			String Day = js1.getString("["+i+"].day");
			
			int Slots=js1.getInt("["+i+"].slots.size()");
			
			String StartTime=js1.getString("slots["+i+"].start");
			String EndTime=js1.getString("slots["+i+"].end");
			
			System.out.println("Day is " +Day);
			System.out.println("Slots are " +Slots);
			System.out.println("Slot start and end time is "  +StartTime +" " +EndTime);
			
			//Day/Slots should not be empty	
			Assert.assertNotEquals(0, Day);
			Assert.assertNotEquals(0, Slots);
			//Start/End time should not be empty
			Assert.assertNotEquals(0, StartTime);
			Assert.assertNotEquals(0, EndTime);
			
			}
					
			
	}
	
	//start date should not be ahead of end date 
	
	@Test
	public void dateValidation()
	{
		RestAssured.baseURI= "https://api.uat.moxiecoach.com";
		
		String response = given()
		.headers(DefaultHeadersParams.defaultHeaders())
		.queryParams(DefaultHeadersParams.dateValidationQueryParams())                           //start date should not be ahead of end date 
		
		.when()
		.get("https://api.uat.moxiecoach.com/me/availability")
		
		.then()
		.log().all()
		.assertThat().statusCode(400)                       //expected 400 status code but displaying 500 
		.extract().response().asString();
		System.out.println(response);
	}
	
	

	
	
	
}
