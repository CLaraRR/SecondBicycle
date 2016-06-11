package com.example.model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DB.DBBean;
import entity.Product;

public class InsertData {

	//获得用户的注册信息后调用getRegister函数进行相关数据处理
	public int getRegister(String name,String psw,String phone,String email,String address)
	{
		  System.out.println("into getresponse");
		  Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs = null;
		  String sql = null;//sql语句
		  int flag=1;

		  try 
		  {
			   conn = DBBean.getConnection();
			   stmt = conn.createStatement();
			   sql = "select * from userinfo;";
			   rs = stmt.executeQuery(sql);//执行sql语句
			   
			   while(rs.next())
			   {
				   //是否和数据库已有的用户名重复
				   if(name.equals(rs.getString("name")))
				   {
					   flag=0;
                       break;
				   }
				   //用正则表达式判断手机号码是否合法
				   String check;
				   Pattern regex;
				   Matcher matcher;
				   if(phone.length()==11)
				   {
					   check="^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$"; //亲测有效！！
					   regex = Pattern.compile(check);
					   matcher = regex.matcher(phone);
					   if(matcher.matches())
					    {
					    	flag=6;
					    	break;
					    }
				   }
				   else
				   { 
					     flag=6;
					     break;
				   }
				  
				    
				    //用正则表达式判断邮箱地址是否合法
				     check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";    
					 regex = Pattern.compile(check);    
					 matcher = regex.matcher(email);    
					   if(!matcher.matches())
					   {
						   flag=5;
						   break;
					   }
				//是否填写用户名和密码
				   if(name.equals("Name"))
				   {
					   flag=2;
                       break;
				   }
				   if(psw.equals("Password"))
				   {
					   flag=3;
                       break;
				   }
				  
				 //是否和数据库已有的邮箱地址重复
				   if(email.equals(rs.getString("email")))
				   {
					   flag=4;
                       break;
				   }

			   }
			  // System.out.println(flag);
			// 以字符串形式编写SQL语句
			   if(flag==1)
			   {
				   //如果用户的注册信息都没有错误，则把数据插入到已建好的数据库的表中
//				   System.out.println(flag);
				   sql="insert into userinfo(name,password,phone,email,address) values" +
	                        "(\""+name+"\",\""+psw+"\",\""+phone+"\",\""+email+"\",\""+address+"\")";
				 
				   System.out.println("get string");
				     // 状态对象执行SQL语句
				   stmt.executeUpdate(sql);
				   System.out.println("successful insert");
				   //把flag连同用户信息一起存到List类型的back中，然后再返回back
			   }

		  } 
		  catch (SQLException e)
		  {
			   System.out.println("数据操作错误");
			   e.printStackTrace();
		  }
		  
			
		//关闭数据库
		  DBBean.clean(conn, stmt, rs);
		  //System.out.println("already close");

		 // System.out.println("successful return");
		return flag;
		
	}
	
	
	
	
	
	
	
	//获得用户的发布产品信息后调用getPublish函数进行相关数据处理，和上面的差不多
	public Product getPublish(String brand,String type,double price,String phone,String other)
	{
		System.out.println("into getresponse");
		//将收集到得数据插入到数据库中String sql="insert into 表名 values ('uerName','pwd')";//插入语句具体执行过程。public static void main(String[] args) {
		  Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs = null;
		  String sql=null;
		  int flag=1;
          Product nowProduct=null;
		  try 
		  {
			   conn=DBBean.getConnection();
			   // 从连接中获取状态
			   stmt = conn.createStatement();
			 
			   sql = "select * from product;";
			   rs = stmt.executeQuery(sql);//执行sql语句
			   
			   //判断手机号码是否合法
			   //一般手机号码是11位数，如果等于11位，再用正则表达式判断
			   if(phone.length()==11)
			   {
				   String check="^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$"; //亲测有效！！例如13112341234是不合法的
				   Pattern regex = Pattern.compile(check);
				   Matcher matcher = regex.matcher(phone);
				   if(matcher.matches())
				    {
				    	flag=0;
				    }
			   }
			   else
				   //如果不是11位则直接判断为不合法
				   flag=0;
			  
			  
			// 以字符串形式编写SQL语句
			     
				   //由于是发布产品信息，所以不用判断信息的对错，直接插入到数据库中就可以了
			   if(flag==1)
			   {  
				   sql="insert into product(brand,type,price,phone,other) values" +
	                        "(\""+brand+"\",\""+type+"\",\""+price+"\",\""+phone+"\",\""+other+"\")";
				 
				   System.out.println("get string");
				     // 状态对象执行SQL语句
				   stmt.executeUpdate(sql);
				   System.out.println("successful insert");
				   
				   sql="select * from product where productid=(select max(productid) from product);";
			       rs=stmt.executeQuery(sql);
			       while(rs.next())
			       {
			    	   long productid=rs.getInt("productid");
			    	   nowProduct=new Product(productid,brand,type,price,phone,other);
			       }
			   } 
		  } 
		  catch (SQLException e)
		  {
			   System.out.println("数据操作错误");
			   e.printStackTrace();
		  }
		  
			
		//关闭数据库
		  DBBean.clean(conn, stmt, rs);
		  System.out.println("successful return");
		return nowProduct;
		
	}
}
