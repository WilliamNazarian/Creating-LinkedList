import java.util.Objects;

public class CellPhone
{
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	//default constructor
	public CellPhone()
	{
		
	}
	
	//constructor
	public CellPhone(long serialNum, String brand, int year, double price)
	{
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	
	//copy constructor
	public CellPhone(CellPhone cellphone, long serialNum)
	{
		this.brand = cellphone.brand;
		this.year = cellphone.year;
		this.price = cellphone.price;
		this.serialNum = serialNum;
	}
	
	//Clone method
	public CellPhone clone(long serialNum)
	{
		return new CellPhone(this, serialNum);
	}
	
	//equals method
	public boolean equals(Object obj)
	{
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		
		CellPhone cell = (CellPhone) obj;
		return (this.brand.equals(cell.brand) && this.year == cell.year && this.price == cell.price);
	}
	
	//toString method
	public String toString()
	{
		return "[serialNum = " + this.serialNum + ", brand = " + this.brand + ", year = " + this.year + ", price = " + this.price + "]";
	}

	//Getters and Setters
	public long getSerialNum()
	{
		return serialNum;
	}

	public void setSerialNum(long serialNum)
	{
		this.serialNum = serialNum;
	}

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}
	
	
}
