package com.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DB.DBBean;
import entity.Order;
import entity.Product;

public class CartData {		//完成数据库与用户购物车页面的数据互通
	
//这部分存在三个函数 UserCart ShowUserCart ShowCart 分别完成对在用户登录状态下与数据库的内容互通，
//显示登录状态用户的购物车内容   显示非登录状态的购物车内容

	//如果用户登录，把购物车的商品存进数据库
	public void UserCart(String productid,String num,HttpServletRequest request) throws SQLException
	{
		  Connection conn = null;	//连接对象
		  Statement stmt = null;	//状态对象
		  ResultSet rs = null;		//结果集
		  String sql=null;
          conn=DBBean.getConnection();
		try 
		  {
			   // 从连接中获取状态
			   stmt = conn.createStatement();
			   
			   //从product表获取product的信息
			   sql="select *from product where productid='"+productid+"';";
			   rs=stmt.executeQuery(sql);
			   String brand = null;
			   String type=null;
			   double price=0;
			   String phone=null;
			   String other=null;
			   String username=null;
			   int nums=Integer.parseInt(num);
			   if(rs.next())
			   {
				   brand=rs.getString("brand");
				   type=rs.getString("type");
				   price=rs.getDouble("price");
				   phone=rs.getString("phone");
				   other=rs.getString("other");
				   
				   System.out.println(brand+" "+type+" "+price+" "+phone+" "+other+" "+nums);
			   }
			   
			   //更新购物车表中的内容，即如果该产品存在则更新数量，如果不存在则添加这条信息
			   HttpSession session=request.getSession(false);
			   if(session!=null)
			   {
				   username=(String) session.getAttribute("user");
			   }
			   sql="select *from usercart where productid='"+productid+"'and username='"+username+"';";
			   rs=stmt.executeQuery(sql);
			   if(rs.next())
			   {
				   sql="update usercart set num="+nums+" where productid='"+productid+"'and username='"+username+"';";
				   stmt.executeUpdate(sql);
				   System.out.println("更新数据");
			   }
			   else
			   {
				   System.out.println("into");
				   
				   sql="insert into usercart(username,productid,brand,type,num,price,totalprice,phone,other) values" +
	                        "(\""+username+"\",\""+productid+"\",\""+brand+"\",\""+type+"\",\""+num+"\",\""+price+"\",\""+price*nums+"\",\""+phone+"\",\""+other+"\")";
				   int result=stmt.executeUpdate(sql);
				   System.out.println("插入数据"+result);
			   }
				System.out.println("成功把商品添加进入usercart表");
		  } 
		  catch (SQLException e)
		  {
			   System.out.println("数据操作错误1");
			   e.printStackTrace();
		  }
	}
	
	//查看当前用户购物车的所有商品信息
	public HashMap showUserCart(HttpServletRequest request)
	{
		  Connection conn = null;//连接对象
		  Statement stmt = null;//状态对象
		  ResultSet rs = null;//结果集
		  String sql = null;//sql语句
		  String username=null;

          
		  HttpSession session=request.getSession(false);
		   if(session!=null)
		   {
			   username=(String) session.getAttribute("user");
		   }
//		  List goods=new ArrayList();
          HashMap goodsList=new HashMap();
          
		try 
		  {
	          conn=DBBean.getConnection();
			   // 从连接中获取状态
			   stmt = conn.createStatement();
			   
			   sql="select *from usercart where username='"+username+"';";
				rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					
					int productid=rs.getInt("productid");
					String brand=rs.getString("brand");
					int num=rs.getInt("num");
					String type=rs.getString("type");
					double price=rs.getDouble("price");
					String phone=rs.getString("phone");
					String other=rs.getString("other");
//					double totalprice=num*price;
					
					Product goods=new Product(productid,brand,type,num,price,phone,other);

					goodsList.put(productid,goods);
					System.out.println("HashMap created success");
				}
		  } 
		  catch (SQLException e)
		  {
			   System.out.println("数据操作错误");
			   e.printStackTrace();
		  }
		return goodsList;
	}
	
	//查看用户未登录时购物车的所有商品信息
	public HashMap showCart(String productid,String num)
	{
		
		  Connection conn = null;//连接对象
		  Statement stmt = null;//状态对象
		  ResultSet rs = null;//结果集
		  String sql = null;//sql语句
		  int productid1=Integer.parseInt(productid);
		  HashMap goodsList=new HashMap();

          conn=DBBean.getConnection();
		try 
		  {
			   // 从连接中获取状态
			   stmt = conn.createStatement();
			   sql="select *from product where productid='"+productid1+"';";
//			   System.out.println("查询成功");
				rs=stmt.executeQuery(sql);
				if(rs.next())
				{
			    String brand=rs.getString("brand");
				String type=rs.getString("type");
				String other=rs.getString("other");
				int nums=Integer.parseInt(num);
				double price=rs.getDouble("price");
				String phone=rs.getString("phone");
			    
				Product goods2=new Product(productid1,brand,type,nums,price,phone,other);
				goodsList.put(productid,goods2);
				//System.out.println(brand+" "+type+" "+other);
				}
		  } 
		  catch (SQLException e)
		  {
			   System.out.println("数据操作错误");
			   e.printStackTrace();
		  }
		return goodsList;
	}
	

}
