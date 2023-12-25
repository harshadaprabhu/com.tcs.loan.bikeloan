package com.tcs.loan.bikeloan.testcases;

import java.io.IOException;
import org.testng.annotations.Test;
import com.tcs.loan.bikeloan.businesslogic.GetAllProjects_BL;

public class GetAllProjects_TC 
{
	GetAllProjects_BL bl;
	
	GetAllProjects_TC() throws IOException
	{
		bl = new GetAllProjects_BL();
	}
	
	@Test(groups= {"sanity"})
	void tc_001_getAllProjects() throws IOException
	{
		bl.getAllProjects();
	}
}
