package application;

public class Orders {
	
	private String name;
	private String product;
	private String price;
	private String date;
	private String delivery;
	private String card;
	private String type;
	private String installments;
	private String Storetype;
	
	
	//Get
	
	public String getName()
    {
    	return name;
    }
	public String getProduct()
    {
    	return product;
    }
	public String getPrice()
    {
    	return price;
    }
	public String getDate()
    {
    	return date;
    }
	public String getDelivery()
    {
    	return delivery;
    }
	public String getCard()
    {
    	return card;
    }
	public String getType()
    {
    	return type;
    }
	public String getInstallments()
    {
    	return installments;
    }
	
	//set
	
	public void setcard(String str)
    {
		this.card= str;
    }
	public void settype(String str)
    {
		this.type= str;
    }
	public void setinstallments(String str)
    {
		this.installments= str;
    }
	public void setdelivery(String str)
    {
		this.delivery= str;
    }
	public void setdate(String str)
    {
		this.date= str;
    }
	public void setprice(String str)
    {
		this.price= str;
    }
	public void setproduct(String str)
    {
		this.product= str;
    }
	public void setname(String str)
    {
		this.name= str;
    }
	public String getStoretype() {
		return Storetype;
	}
	public void setStoretype(String storetype) {
		Storetype = storetype;
	}
	
	
}
