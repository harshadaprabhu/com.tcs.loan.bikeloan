package com.tcs.loan.bikeloan.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tcs.loan.bikeloan.businesslogic.GetProjectByID_BL;

public class GetProjectByID_TC 
{
	GetProjectByID_BL bl;
	
	
	GetProjectByID_TC() throws IOException
	{
		bl = new GetProjectByID_BL();
	}
	
	@Test(description = "Getting project details of id which is valid", groups= {"sanity"})
	void tc_001_getProjectByValidId()
	{
		bl.getProjByValidId();
	}
	
	@Test(description = "Getting project details of id which does not exists", groups= {"sanity","regression"})
	void tc_001_getProjectByInvalidId()
	{
		bl.getProjByInvalidId();
	}
}
