package Files;

import java.util.HashMap;
import java.util.Map;

import MoxieTestPackage.Authentication;

public class DefaultHeadersParams {


	
		public static Map<String, String> defaultHeaders(){
			Map<String, String> defaultHeaders = new HashMap<String, String>();
		defaultHeaders.put("Authorization", Authentication.BearerToken());
		defaultHeaders.put("orgid","1");
		defaultHeaders.put("Accept","application/json");
		
				return defaultHeaders;
		
	}
	
	public static Map<String, String> queryParams()
	{
		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("fromDate", "2021-07-19");   //hardcode should be avoided, create constant 
		queryParams.put("toDate", "2021-09-25");
		
		return queryParams;
		
	}
	
	public static Map<String, String> dateValidationQueryParams()
	{
		Map<String, String> dateValidationQueryParams = new HashMap<String, String>();
		dateValidationQueryParams.put("fromDate", "2021-09-26");
		dateValidationQueryParams.put("toDate", "2021-09-25");
		return dateValidationQueryParams;
		
		
	}
	public static Map<String, String> tokenValidationHeaders()
	{
		Map<String, String> tokenValidationHeader = new HashMap<String, String>();
		tokenValidationHeader.put("Authorization", "");
		tokenValidationHeader.put("orgid","1");
		tokenValidationHeader.put("Accept","application/json");
		return tokenValidationHeader;
		
	}
	
}