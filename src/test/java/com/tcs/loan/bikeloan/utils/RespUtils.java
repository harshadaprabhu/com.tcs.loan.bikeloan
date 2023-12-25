package com.tcs.loan.bikeloan.utils;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.http.Cookie;

public class RespUtils 
{
	boolean flag = false;
	// Response status verification
	public boolean verifyStatusCodeLine_200(int statusCode, String statusLine)
	{
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		Assert.assertTrue(statusLine.contains("OK"));
		flag = true;
		return flag;
	}
	
	public boolean verifyStatusCodeLine_201(int statusCode, String statusLine)
	{
		Assert.assertEquals(statusCode, 201);
		Assert.assertEquals(statusLine, "HTTP/1.1 201 CREATED");
		Assert.assertTrue(statusLine.contains("CREATED"));
		flag = true;
		return flag;
	}
	
	public boolean verifyStatusCodeLine_204(int statusCode, String statusLine)
	{
		Assert.assertEquals(statusCode, 204);
		Assert.assertEquals(statusLine, "HTTP/1.1 204 NO CONTENT");
		Assert.assertTrue(statusLine.contains("NO CONTENT"));
		flag = true;
		return flag;
	}
	
	// 400 series
	public boolean verifyStatusCodeLine_400(int statusCode, String statusLine)
	{
		Assert.assertEquals(statusCode, 400);
		Assert.assertEquals(statusLine, "HTTP/1.1 400 BAD REQUEST");
		Assert.assertTrue(statusLine.contains("BAD REQUEST"));
		flag = true;
		return flag;
	}
	
	public boolean verifyStatusCodeLine_401(int statusCode, String statusLine)
	{
		Assert.assertEquals(statusCode, 401);
		Assert.assertEquals(statusLine, "HTTP/1.1 401 UNAUTHORIZED");
		Assert.assertTrue(statusLine.contains("UNAUTHORIZED"));
		flag = true;
		return flag;
	}
	
	public boolean verifyStatusCodeLine_403(int statusCode, String statusLine)
	{
		Assert.assertEquals(statusCode, 403);
		Assert.assertEquals(statusLine, "HTTP/1.1 403 FORBIDDENT");
		Assert.assertTrue(statusLine.contains("FORBIDDENT"));
		flag = true;
		return flag;
	}
	
	public boolean verifyStatusCodeLine_404(int statusCode, String statusLine)
	{
		Assert.assertEquals(statusCode, 404);
		Assert.assertEquals(statusLine, "HTTP/1.1 404 NOT FOUND");
		Assert.assertTrue(statusLine.contains("NOT FOUND"));
		flag = true;
		return flag;
	}
	
	// 500 SERIES
	public boolean verifyStatusCodeLine_500(int statusCode, String statusLine)
	{
		Assert.assertEquals(statusCode, 500);
		Assert.assertEquals(statusLine, "HTTP/1.1 500 INTERNAL SERVER ERROR");
		Assert.assertTrue(statusLine.contains("INTERNAL SERVER ERROR"));
		flag = true;
		return flag;
	}
	
	//Headers
	public boolean verifyHeaderServer(String headerActual)
	{
		Assert.assertEquals(headerActual, "AtlassianEdge");
		flag = true;
		return flag;
	}
	
	public boolean verifyHeaderContentType(String headerActual)
	{
		Assert.assertEquals(headerActual, "application/json;charset=UTF-8");
		Assert.assertTrue(headerActual.contains("json"));
		flag = true;
		return flag;
	}
	
	public boolean verifyHeaderAccountId(String headerActual)
	{
		Assert.assertEquals(headerActual, "712020%3Ad1f77ce6-6c5a-4a1b-99e4-a3d57b9b4e79");
		flag = true;
		return flag;
	}
	
	public boolean verifyHeader(String headerActual, String expectedHeader)
	{
		Assert.assertEquals(headerActual, expectedHeader);
		flag = true;
		return flag;
	}
	
	//verify cookie
	public void verifyCookie(Cookie c, int version)
	{
		Assert.assertEquals(c.hasVersion(), version);
		Assert.assertEquals(c.isSecured(), true);
		Assert.assertEquals(c.getMaxAge(), 10);
	}
	
	//Verify time
	public void verifyRespTime(long actual, int expected)
	{
		Assert.assertTrue(actual < expected);
	}
	
	//handling resp body
	public JsonObject returnJsonObject(String payload)
	{
		Assert.assertFalse(payload.isBlank());
		Assert.assertFalse(payload.isEmpty());
		JsonObject obj = JsonParser.parseString(payload).getAsJsonObject();
		return obj;
	}
	
	public JsonArray retunJsonArray(String keyName, JsonObject respObj)
	{
		JsonArray arr;
		arr = respObj.get(keyName).getAsJsonArray();
		return arr;
	}
	
	public JsonObject returnObjFromJsonArray(JsonArray arr, int index)
	{
		JsonObject obj = arr.get(index).getAsJsonObject();
		return obj;
	}
}



