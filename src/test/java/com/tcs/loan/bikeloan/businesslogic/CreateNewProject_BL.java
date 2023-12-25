package com.tcs.loan.bikeloan.businesslogic;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import com.tcs.loan.bikeloan.base.Base;
import com.tcs.loan.bikeloan.reqpayloads.CreateNewProject_ReqPaylaod;

import static io.restassured.RestAssured.given;

public class CreateNewProject_BL extends Base
{
	Logger log = LogManager.getLogger(CreateNewProject_BL.class.getName());
	
	public CreateNewProject_BL() throws IOException 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void createProject()
	{
		try
		{
			resp = given().log().all()
					.spec(getRequestSpecWithPayload(basicConfig.getProperty("baseurl"), basicConfig.getProperty("basepath_createproject"),CreateNewProject_ReqPaylaod.generateReqPayload()))
				   .when()
				   	.post()
				   .then().log().all()
				   	.extract()
				   	.response();
				
		}
		catch(Exception e)
		{
			log.error(e.fillInStackTrace());
		}
		finally
		{
			log.info("Hello Testcase pass");
			System.out.println("hello");
		}
	}
	
	@Test(enabled=false)
	public void createProjectWithEmptyKey()
	{
		resp = given().log().all()
				.spec(getRequestSpecWithPayload(basicConfig.getProperty("baseurl"), basicConfig.getProperty("basepath_createproject"),CreateNewProject_ReqPaylaod.generatePayloadForInvalidKey("")))
			   .when()
			   	.post()
			   .then().log().all()
			   	.extract()
			   	.response();

	}
	
	@Test(enabled=false)
	public void createProjectWithNullKey()
	{
		resp = given().log().all()
				.spec(getRequestSpecWithPayload(basicConfig.getProperty("baseurl"), basicConfig.getProperty("basepath_createproject"),CreateNewProject_ReqPaylaod.generatePayloadForInvalidKey(null)))
			   .when()
			   	.post()
			   .then().log().all()
			   	.extract()
			   	.response();

	}

	@Test(enabled=false)
	public void createProjectWithKeyStartingSmallLetter()
	{
		resp = given().log().all()
				.spec(getRequestSpecWithPayload(basicConfig.getProperty("baseurl"), basicConfig.getProperty("basepath_createproject"),CreateNewProject_ReqPaylaod.generatePayloadForInvalidKey("a2233ssss")))
			   .when()
			   	.post()
			   .then().log().all()
			   	.extract()
			   	.response();

	}
}
