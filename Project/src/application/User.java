package application;



public class User {
	private String id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	
	private String email;
	private String card;
	private String Date;
	private String Status;
	
	
//GET
	

	
	public String getId()
    {
    	return id;
    }
	public String getDate()
    {
    	return Date;
    }public String getStatus()
    {
    	return Status;
    }
	public String getUsername()
	{
		return username;
	}
	public String getFirstname()
	{
		return firstname;
	}
	public String getLastname()
	{
		return lastname;
	}
	public String getEmail()
	{
		return email;
	}
	public String getCard()
	{
		return card;
	}
	public String getPassword()
	{
		return password;
	}
	
	//SET
	public void setId(String str)
    {
    	this.id = str;
    }
	public void setDate(String str)
    {
    	this.Date = str;
    }public void setStatus(String str)
    {
    	this.Status = str;
    }
	public void setusername(String str)
    {
    	this.username= str;
    }
	public void setfirstname(String str)
    {
		this.firstname= str;
    }
	public void setlastname(String str)
    {
		this.lastname= str;
    }
	public void setemail(String str)
    {
		this.email= str;
    }	
	public void setcard(String str)
    {
		this.card= str;
    }	
	public void setpassword(String str)
    {
		this.password= str;
    }
 

 

	
	
}
