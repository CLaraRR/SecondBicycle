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
//�������ɲ�ѯ��������Ҫ���ڵ�¼ʱ�ж�����û��Ƿ���������ݿ���
	
	//�û�login�󣬵���getData���������ݽ�����ش����������ݿ�
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
			   rs = stmt.executeQuery(sql);//ִ��sql���
			   
			   //�����ж�
			   while(rs.next())
			   {
				   if(name.equals(rs.getString("name")))//���ж����ݿ����Ƿ���������û���
				   {
					   if(psw.equals(rs.getString("password")))//�еĻ������ж�����������ȷ
					   {
                           //��½�ɹ�
						   flag=1;
						   break;
					   }
					   else
					   {
						   //���벻��ȷ

						   flag=2;
						   break;
					   }   
				   }
			   }
			  
			   System.out.println(flag);
		  } 
		  catch (SQLException e)
		  {
			   System.out.println("���ݲ�������");
			   e.printStackTrace();
		  }
		  
			
		//�ر����ݿ�
		  DBBean.clean(conn, stmt, rs);
		  //System.out.println("already close");
		 // System.out.println("successful return");
		return flag;
	}
}
