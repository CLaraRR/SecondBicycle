package com.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import DB.DBBean;

public class SearchData {
//这个类完成查询工作，主要用在登录时判断这个用户是否存在于数据库中
	
	//用户login后，调用getData函数对数据进行相关处理并插入数据库
	public int getData(String name,String psw)
	{
		  System.out.println("into getresponse");
		  Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs = null;
		  String sql=null;
		  int flag=0;
		  
		  try 
		  {
			   conn=DBBean.getConnection();
			   stmt = conn.createStatement();
			   //System.out.println("get stmt");
			   sql = "select * from userinfo;";
			   rs = stmt.executeQuery(sql);//执行sql语句
			   
			   //逐行判断
			   while(rs.next())
			   {
				   if(name.equals(rs.getString("name")))//先判断数据库中是否已有这个用户名
				   {
					   if(psw.equals(rs.getString("password")))//有的话，再判断密码整不正确
					   {
                           //登陆成功
						   flag=1;
						   break;
					   }
					   else
					   {
						   //密码不正确

						   flag=2;
						   break;
					   }   
				   }
			   }
			  
			   System.out.println(flag);
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
}
