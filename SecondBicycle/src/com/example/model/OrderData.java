package com.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DB.DBBean;
import entity.Order;

public class OrderData {
	
	//用户要对商品下单，在数据库创建一个订单记录,返回订单
		public void createOrder(String productid,HttpServletRequest request)
		{
			  Connection conn = null;//连接对象
			  Statement stmt = null;//状态对象
			  ResultSet rs = null;//结果集
			  String sql = null;//sql语句
			  String orderid=null;
			  String brand=null;
			  String type=null;
			  String other=null;
			  int num=0;
			  double price=0;
			  double totalprice=0;
			  String phone=null;
			  String username=null;
	          conn=DBBean.getConnection();
			  try 
			  {
				stmt = conn.createStatement();
			    sql="select *from usercart where productid='"+productid+"';";
			    System.out.println(productid);
			    
			    rs=stmt.executeQuery(sql);

				System.out.println("查询成功");
				if(rs.next())
				{
					brand=rs.getString("brand");
					type=rs.getString("type");
					other=rs.getString("other");
					num=rs.getInt("num");
					price=rs.getDouble("price");
					totalprice=rs.getDouble("totalprice");
				} 
				HttpSession session=request.getSession(false);
				if(session!=null)
				{
					username=(String) session.getAttribute("user");
				sql="insert into orderlist(username,productid,brand,type,num,price,totalprice,other) values" +
                        "(\""+username+"\",\""+productid+"\",\""+brand+"\",\""+type+"\",\""+num+"\",\""+price+"\",\""+totalprice+"\",\""+other+"\")";
				stmt.executeUpdate(sql);
				}
				
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("数据操作错误");
				e.printStackTrace();
			}
		}
		
		//获得当前的订单
		public Order getOrder()
		{
			  Connection conn = null;//连接对象
			  Statement stmt = null;//状态对象
			  ResultSet rs = null;//结果集
			  String sql = null;//sql语句
			  int orderid=0;
			  String productid=null;
			  String brand=null;
			  String type=null;
			  String other=null;
			  int num=0;
			  double price=0;
			  double totalprice=0;
			  String phone=null;
			  String username=null;
	          conn=DBBean.getConnection();
			 try{  
				    stmt = conn.createStatement();
				    sql="select * from orderlist where orderid=(select max(orderid) from orderlist);";
			        rs=stmt.executeQuery(sql);//获得订单号
					//获得当前订单
					if(rs.next())
					{
						username=rs.getString("username");
						orderid=rs.getInt("orderid");
						productid=rs.getString("productid");
						brand=rs.getString("brand");
						type=rs.getString("type");
						other=rs.getString("other");
						num=rs.getInt("num");
						price=rs.getDouble("price");
						totalprice=rs.getDouble("totalprice");
						
						Order nowOrder=new Order(orderid,username,productid,brand,type,num,price,totalprice,other);
						return nowOrder;
					}		
			 }
			 catch(SQLException e)
			 {
				 e.printStackTrace();
			 }
			return null;	
		}
}
