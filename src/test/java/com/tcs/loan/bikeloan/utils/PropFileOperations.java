package com.tcs.loan.bikeloan.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropFileOperations 
{
	private String filePath;
	private FileInputStream fin;
	private Properties prop;
	
	public PropFileOperations()
	{
		filePath = null;
		fin = null;
		prop = new Properties();
	}
	
	public Properties getProp(String fileName) throws IOException
	{
		filePath = System.getProperty("user.dir") + File.separator + "InputFiles" + File.separator + fileName; 
		try 
		{
			fin = new FileInputStream(filePath);
			prop.load(fin);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
}
