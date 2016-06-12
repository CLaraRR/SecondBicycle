package entity;

public class Product {			//产品信息
	private long  productid;
	private String brand;
	private String type;
	private int num;
	private double price;
	private String phone;
	private String other;
	
	public Product(){
		
	}
	public Product(long productid2, String brand, String type, int num,double price,String phone,
			String other) {
		super();
		this.productid = productid2;
		this.brand = brand;
		this.type = type;
		this.num = num;
		this.price = price;
		this.phone=phone;
		this.other=other;
		
	}
	public Product( long productid,String brand, String type,double price,String phone,String other) {
		super();
		this.productid=productid;
		this.brand = brand;
		this.type = type;
		this.price = price;
		this.phone=phone;
		this.other=other;
		
	}
	public void setProductid(long productid)
	{
		this.productid = productid;
	}
	public long getProductid()
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
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getPhone()
	{
		return phone;
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
