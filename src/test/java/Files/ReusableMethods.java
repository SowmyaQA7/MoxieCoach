package Files;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class ReusableMethods {
	public static JsonPath rawToJson(String response)
	{
		JsonPath js1 =new JsonPath(response);
		return js1;
	}
	
	public static RequestSpecification getSpec()
	{
		RequestSpecification req = new RequestSpecBuilder()
				.setBaseUri("https://api.uat.moxiecoach.com")
				.addHeaders(DefaultHeadersParams.defaultHeaders())
				.setBody(JsonBody.CreateSession())
				.build();
		return req;
	}
	
	public static RequestSpecification getAvailability()
	{
		RequestSpecification GetReq = new RequestSpecBuilder()
				.setBaseUri("https://api.uat.moxiecoach.com")
				.addHeaders(DefaultHeadersParams.defaultHeaders())
				.addQueryParams(DefaultHeadersParams.queryParams())
				.build();
		return GetReq;
		
	}
}
