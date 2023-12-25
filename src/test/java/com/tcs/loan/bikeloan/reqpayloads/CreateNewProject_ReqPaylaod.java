package com.tcs.loan.bikeloan.reqpayloads;

import org.apache.commons.lang3.RandomStringUtils;

public class CreateNewProject_ReqPaylaod 
{

	public static String generatePayloadForInvalidKey(String key)
	{
		
		String reqPayload = "{\r\n" + 
				"  \"assigneeType\": \"PROJECT_LEAD\",\r\n" + 
				"  \"description\": \"Cloud migration initiative\",\r\n" + 
				"  \"key\": \""+key+"\",\r\n" + 
				"  \"leadAccountId\": \"712020:d1f77ce6-6c5a-4a1b-99e4-a3d57b9b4e79\",\r\n" + 
				"  \"name\": \""+key+"\",\r\n" + 
				"  \"projectTypeKey\": \"software\",\r\n" + 
				"  \"projectTemplateKey\": \"com.pyxis.greenhopper.jira:gh-simplified-agility-scrum\",\r\n" + 
				"  \"url\": \"http://atlassian.com\"\r\n" + 
				"}";
		
		return reqPayload;
	}
	
	public static String generateReqPayload()
	{
		String key = RandomStringUtils.randomAlphabetic(10).toUpperCase();
		
		String reqPayload = "{\r\n" + 
				"  \"assigneeType\": \"PROJECT_LEAD\",\r\n" + 
				"  \"description\": \"Cloud migration initiative\",\r\n" + 
				"  \"key\": \""+key+"\",\r\n" + 
				"  \"leadAccountId\": \"712020:d1f77ce6-6c5a-4a1b-99e4-a3d57b9b4e79\",\r\n" + 
				"  \"name\": \""+key+"\",\r\n" + 
				"  \"projectTypeKey\": \"software\",\r\n" + 
				"  \"projectTemplateKey\": \"com.pyxis.greenhopper.jira:gh-simplified-agility-scrum\",\r\n" + 
				"  \"url\": \"http://atlassian.com\"\r\n" + 
				"}";
		
		return reqPayload;
	}
	
}
