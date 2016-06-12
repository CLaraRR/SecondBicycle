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
	//这个类完成了订单和数据库的互通，包括两个函数，构造一个订单并且将它存储到orlderlist1中，和函数查询最新订单的操作。
	int OrderID;
	
	//用户要对商品下单，在数据库创建一个订单记录,返回订单
		public void createOrder(String productid,HttpServletRequest request)
		{
			//数据库相关准备
			  Connection conn = null;//连接对象
			  Statement stmt = null;//状态对象
			  ResultSet rs = null;//结果集
			  String sql = null;//sql语句
			  
			//实体内容准备
			  int orderid=0;
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
                        "('"+username+"','"+productid+"','"+brand+"','"+type+"',"+num+","+price+","+totalprice+",'"+other+"')";
					stmt.executeUpdate(sql);
					
					sql="select orderid from orderlist where productid='"+productid+"'and username='"+username+"';";
					rs=stmt.executeQuery(sql);
					if(rs.next())
						orderid=rs.getInt("orderid");
					else
						System.out.println("没有获取到相应订单");
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("数据操作错误——向订单表中插入信息");
				e.printStackTrace();
			}
			OrderID=orderid;
		}
		
		//获得当前的订单
		public Order getOrder()
		{
			//数据库操作准备
			  Connection conn = null;//连接对象
			  Statement stmt = null;//状态对象
			  ResultSet rs = null;//结果集
			  String sql = null;//sql语句
			 
			 //产品实体内容准备
			  int orderid=OrderID;
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
				    sql="select * from orderlist where orderid="+orderid+";";
			        rs=stmt.executeQuery(sql);//获得订单号
					//获得当前订单
			        System.out.println("orderid:"+orderid);
					if(rs.next())
					{
						System.out.println("找到相应订单");
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
