package MoxieTestPackage;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class Authentication {

	@Test
	public static String BearerToken(){
		
		RestAssured.baseURI="https://www.googleapis.com";
		
		String token = given()
		.queryParam("key", "AIzaSyChf-6L1rMuP7hsLGE4moxHDptr7ZUXvV8")
		.body("{\r\n"
				+ "  \"email\": \"emma+winston+uatCoach+instructor@cla.com\",\r\n"
				+ "  \"password\": \"qwerty@123\",\r\n"
				+ "  \"returnSecureToken\": true\r\n"
				+ "}")
		.when()
		.post("identitytoolkit/v3/relyingparty/verifyPassword").path("idToken");  
		System.out.println(token);
		return token;
		
	
	
	}
	
}
