package com.tcs.loan.bikeloan.base;

import java.io.IOException;
import java.util.Properties;

import com.tcs.loan.bikeloan.utils.JsonUtilities;
import com.tcs.loan.bikeloan.utils.PropFileOperations;
import com.tcs.loan.bikeloan.utils.RespUtils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base 
{
	protected Response resp;
	protected String reqPayload;
	protected PropFileOperations po = new PropFileOperations();
	protected RespUtils respUtil;
	protected JsonUtilities ju;
	protected Properties basicConfig = po.getProp("basicConfig.properties");
	protected Properties testData = po.getProp("testData.properties");
	
	public Base() throws IOException
	{
		respUtil = new RespUtils();
		ju = new JsonUtilities();		
	}
		
	protected RequestSpecification getRequestSpec(String baseUrl, String basePath)
	{
		RequestSpecification reqSpec = new RequestSpecBuilder()
										.setBaseUri(baseUrl)
										.setBasePath(basePath)
										.addHeader("Authorization", "Basic eW9nZXNoQHRlc3RvbWV0ZXIub3JnOkFUQVRUM3hGZkdGMEs1VlJlOW9feVQtV2hrOFZkS25BME1YQ0lOWWNEcjE3TVFRVHRsWGQ3ZXdHSWVvdG53TDJNTkNreVdocE5vOFBUUE9UQUZNMmpBRWw3N1A0RVVfVFVyRDNGeDVCVHM1SEdOT1AtUWZnMlZOOTU2WWRBSG56MGpkODVpSWJyZWMtZ1FhR1dEdU9fS3RoY3JGaEtrYnNGZnJPVDZjYVVIUDk2VXpEajdqdjJqUT1GMDk5RTdDMA==")
										.build();
		
		return reqSpec;
	}
	
	protected RequestSpecification getRequestSpecWithPayload(String baseUrl, String basePath, String payload)
	{
		RequestSpecification reqSpec = new RequestSpecBuilder()
										.setBaseUri(baseUrl)
										.setBasePath(basePath)
										.setContentType(ContentType.JSON)
										.setBody(payload)
										.addHeader("Authorization", "Basic eW9nZXNoQHRlc3RvbWV0ZXIub3JnOkFUQVRUM3hGZkdGMEs1VlJlOW9feVQtV2hrOFZkS25BME1YQ0lOWWNEcjE3TVFRVHRsWGQ3ZXdHSWVvdG53TDJNTkNreVdocE5vOFBUUE9UQUZNMmpBRWw3N1A0RVVfVFVyRDNGeDVCVHM1SEdOT1AtUWZnMlZOOTU2WWRBSG56MGpkODVpSWJyZWMtZ1FhR1dEdU9fS3RoY3JGaEtrYnNGZnJPVDZjYVVIUDk2VXpEajdqdjJqUT1GMDk5RTdDMA==")
										.build();
		
		return reqSpec;
	}
	
	protected RequestSpecification getRequestSpecWithPathParam(String baseUrl, String basePath, String pathParamname, String pathParamValue)
	{
		RequestSpecification reqSpec = new RequestSpecBuilder()
										.setBaseUri(baseUrl)
										.setBasePath(basePath)
										.addPathParam(pathParamname, pathParamValue)
										.addHeader("Authorization", "Basic eW9nZXNoQHRlc3RvbWV0ZXIub3JnOkFUQVRUM3hGZkdGMEs1VlJlOW9feVQtV2hrOFZkS25BME1YQ0lOWWNEcjE3TVFRVHRsWGQ3ZXdHSWVvdG53TDJNTkNreVdocE5vOFBUUE9UQUZNMmpBRWw3N1A0RVVfVFVyRDNGeDVCVHM1SEdOT1AtUWZnMlZOOTU2WWRBSG56MGpkODVpSWJyZWMtZ1FhR1dEdU9fS3RoY3JGaEtrYnNGZnJPVDZjYVVIUDk2VXpEajdqdjJqUT1GMDk5RTdDMA==")
										.build();
		
		return reqSpec;
	}
}
