package entity;

public class Order {			//订单
	private int orderid;
	private String username;
	private String productid;
	private String brand;
	private String type;
	private int num;
	private double price;
	private double totalprice;
	private String other;
	
	public Order(int orderid,String username,String productid, String brand, String type, int num,double price,double totalprice,
			String other) {		//构造函数
		super();
		this.username=username;
		this.orderid=orderid;
		this.productid = productid;
		this.brand = brand;
		this.type = type;
		this.num = num;
		this.price = price;
		this.totalprice=totalprice;
		this.other=other;
	}
	
	public void setOrderid(int orderid)
	{
		this.orderid=orderid;
	}
	public int getOrderid()
	{
		return orderid;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUsername()
	{
		return username;
	}
	public void setProductid(String productid)
	{
		this.productid = productid;
	}
	public String getProductid()
	{
		return productid;
	}
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	public String getBrand()
	{
		return brand;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public String getType()
	{
		return type;
	}
	public void setNum(int num)
	{
		this.num = num;
	}
	public int getNum()
	{
		return num;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public double getPrice()
	{
		return price;
	}
	public void setTotalprice(double totalprice)
	{
		this.totalprice = totalprice;
	}
	public double getTotalprice()
	{
		return totalprice;
	}

	public void setOther(String other)
	{
		this.other = other;
	}
	public String getOther()
	{
		return other;
	}

}
