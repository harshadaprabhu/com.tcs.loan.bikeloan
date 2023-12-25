package com.tcs.loan.bikeloan.businesslogic;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.tcs.loan.bikeloan.base.Base;
import io.restassured.response.Response;

public class GetProjectByID_BL extends Base
{
	public GetProjectByID_BL() throws IOException
	{
		super();
	}
	
	
	public void getProjByValidId()
	{
		Response resp;
		resp = 	given()
					.spec(getRequestSpecWithPathParam(basicConfig.getProperty("baseurl"), basicConfig.getProperty("basepath_getprojectbyid"), "ProjectKey", "HARSH"))
				.when()
					.get()
				.then()
					.log().all()
					.extract()
					.response();
		
		Assert.assertTrue(respUtil.verifyStatusCodeLine_200(resp.getStatusCode(), resp.getStatusLine()));
		Assert.assertTrue(respUtil.verifyHeaderAccountId(resp.getHeader(basicConfig.getProperty("resp_header_accountid"))));
		Assert.assertTrue(respUtil.verifyHeaderContentType(resp.getContentType()));
		Assert.assertTrue(respUtil.verifyHeaderServer(resp.getHeader(basicConfig.getProperty("resp_header_server"))));
		respUtil.verifyRespTime(resp.getTime(), 2000);
		Assert.assertTrue(respUtil.verifyHeader(resp.getHeader(basicConfig.getProperty("resp_header_server")), "AtlassianEdge"));
	}
	
	
	
	public void getProjByInvalidId()
	{
		Response resp;
		resp = 	given()
					.spec(getRequestSpecWithPathParam(basicConfig.getProperty("baseurl"), basicConfig.getProperty("basepath_getprojectbyid"), "ProjectKey", "HARSH123"))
				.when()
					.get()
				.then()
					.log().all()
					.extract()
					.response();
	}

}
