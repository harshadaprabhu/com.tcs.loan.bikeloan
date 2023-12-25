package com.tcs.loan.bikeloan.businesslogic;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tcs.loan.bikeloan.base.Base;

import io.restassured.response.Response;

public class GetAllProjects_BL extends Base
{
	Logger log = LogManager.getLogger(GetAllProjects_BL.class.getName());

	public GetAllProjects_BL() throws IOException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void getAllProjects() throws IOException
	{
		
		resp = given()
					.spec(getRequestSpec(basicConfig.getProperty("baseurl"), basicConfig.getProperty("basepath_getallproj")))
					.log().all()
				.when()
					.get()
				.then()
					.extract()
					.response();
		
		log.info("============= Basic Response =================");
		Assert.assertTrue(respUtil.verifyStatusCodeLine_200(resp.getStatusCode(), resp.getStatusLine()));
		Assert.assertTrue(respUtil.verifyHeaderAccountId(resp.getHeader(basicConfig.getProperty("resp_header_accountid"))));
		Assert.assertTrue(respUtil.verifyHeaderContentType(resp.getContentType()));
		Assert.assertTrue(respUtil.verifyHeaderServer(resp.getHeader(basicConfig.getProperty("resp_header_server"))));
		respUtil.verifyRespTime(resp.getTime(), 2000);
		
		
		log.info("============= RespBody================");
		JsonObject respJsonObj = ju.getJsonObject(resp.getBody().asPrettyString());
		JsonArray valuesArr = ju.getJsonArr(respJsonObj, "values");
		
		for(int i = 0; i < valuesArr.size(); i++)
		{
			log.info("---------------------");
			JsonObject valueObj = valuesArr.get(i).getAsJsonObject();
			log.info(valueObj.get("expand"));
			Assert.assertEquals(valueObj.get("expand").getAsString(), testData.getProperty("getallprojects_expand"));
			log.info("---------------------");
		}
		
		Assert.assertTrue(respJsonObj.get("self").getAsString().contains(basicConfig.getProperty("baseurl")));
		int max_result = Integer.parseInt(testData.getProperty("getallprojects_maxresults"));
		Assert.assertEquals(respJsonObj.get("maxResults").getAsInt(), max_result);
	
	}
}
