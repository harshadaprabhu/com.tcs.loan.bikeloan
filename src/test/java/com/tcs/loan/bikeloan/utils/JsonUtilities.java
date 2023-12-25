package com.tcs.loan.bikeloan.utils;

import org.testng.Assert;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonUtilities 
{

	public JsonObject getJsonObject(String payload)
	{
		JsonObject obj = null;
		if((payload.isBlank() == false) && (payload.isEmpty() == false))
		{
			obj = JsonParser.parseString(payload).getAsJsonObject();
		}
		else
		{
			System.out.println("payload is either empty or blank");
		}
		return obj;
	}
	
	public JsonArray getJsonArr(String payload)
	{
		JsonArray arr = null;
		if((payload.isBlank() == false) && (payload.isEmpty() == false))
		{
			arr = JsonParser.parseString(payload).getAsJsonArray();
		}
		else
		{
			System.out.println("payload is either empty or blank");
		}
		return arr;
	}
	
	public JsonArray getJsonArr(JsonObject obj, String key)
	{
		JsonArray arr = null;
		if((obj.isJsonObject() == true) && (obj.isJsonNull() == false) && (key.isBlank() == false) && (key.isEmpty() == false))
		{
			Assert.assertTrue(obj.has(key));
			Assert.assertTrue(obj.get(key).isJsonArray());
			arr = obj.get(key).getAsJsonArray();
		}
		else
		{
			System.out.println("Either provided jsonObj is null or key is empty or key is blank");
		}
		return arr;
	}
}


