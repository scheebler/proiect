package entities;

public class Destination {

	String name;
	int price;
	public Destination()
	{
		
	}
	
	public Destination (String name, int price)
	{
		this.name = name;
		this.price = price;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setPrice(int price)
	{
		this.price=price;
	}
	
	public int getPrice()
	{
		return price;
	}
}
