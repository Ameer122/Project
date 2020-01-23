package application;

import javafx.beans.property.StringProperty;

public class Reports {
	
	private String username;	
	private String email;
	private String date;
	private String phone;
	private String complain;
	private String status;
	

	 
	//GET
	
	
	public String getUsername()
    {
    	return username;
    }
	public String getEmail()
	{
		return email;
	}
	public String getDate()
	{
		return date;
	}
	public String getComplain()
	{
		return complain;
	}
	public String getPhone()
	{
		return phone;
	}
	public String getStatus()
    {
    	return status;
    }
	
	//SET
	//Get Property
	
	public void setusername(String str)
	{
		this.username= str;
		
	}
	public void setemail(String str)
	{
	this.email= str;
	
	}
	public void setdate(String str)
	{
		this.date= str;
		
	}
	public void setcomplaint(String str)
	{
		this.complain= str;
	
	}
	public void setstaus(String str)
	{
		this.status= str;
		
	}
	public void setphone(String str)
	{
		this.phone= str;
		
	}
	
	
}

