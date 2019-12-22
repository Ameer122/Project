package application;

import java.io.FileInputStream;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class TableController  {


	private final StringProperty id;
	private StringProperty name;
	private StringProperty description;
	private StringProperty price;
	

 TableController(String id, String name, String description, String price)
{
	this.id = new SimpleStringProperty(id);
	this.description = new SimpleStringProperty(description);
	this.name = new SimpleStringProperty(name);
	this.price = new SimpleStringProperty(price);
	
}
 
public String getId()
{
	return id.get();
}
public String getprice()
{
	return price.get();
}
public String getname()
{
	return name.get();
}
public String getdescription()
{
	return description.get();
}
public void setId(String str)
{
	id.set(str);;
}
public void setprice(String str)
{
	price.set(str);
}
public void setname(String str)
{
	name.set(str);;
}
public void setdescription(String str)
{
	description.set(str);
}
public StringProperty nameProperty() {return name;}
public StringProperty idProperty() {return id;}
public StringProperty priceProperty() {return price;}
public StringProperty descriptionProperty() {return description;}

}
