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

	//����û���ע����Ϣ�����getRegister��������������ݴ���
	public int getRegister(String name,String psw,String phone,String email,String address)
	{
		  System.out.println("into getresponse");
		  Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs = null;
		  String sql = null;//sql���
		  int flag=1;

		  try 
		  {
			   conn = DBBean.getConnection();
			   stmt = conn.createStatement();
			   sql = "select * from userinfo;";
			   rs = stmt.executeQuery(sql);//ִ��sql���
			   
			   while(rs.next())
			   {
				   //�Ƿ�����ݿ����е��û����ظ�
				   if(name.equals(rs.getString("name")))
				   {
					   flag=0;
                       break;
				   }
				   //��������ʽ�ж��ֻ������Ƿ�Ϸ�
				   String check;
				   Pattern regex;
				   Matcher matcher;
				   if(phone.length()==11)
				   {
					   check="^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$"; //�ײ���Ч����
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
				  
				    
				    //��������ʽ�ж������ַ�Ƿ�Ϸ�
				     check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";    
					 regex = Pattern.compile(check);    
					 matcher = regex.matcher(email);    
					   if(!matcher.matches())
					   {
						   flag=5;
						   break;
					   }
				//�Ƿ���д�û���������
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
				  
				 //�Ƿ�����ݿ����е������ַ�ظ�
				   if(email.equals(rs.getString("email")))
				   {
					   flag=4;
                       break;
				   }

			   }
			  // System.out.println(flag);
			// ���ַ�����ʽ��дSQL���
			   if(flag==1)
			   {
				   //����û���ע����Ϣ��û�д���������ݲ��뵽�ѽ��õ����ݿ�ı���
//				   System.out.println(flag);
				   sql="insert into userinfo(name,password,phone,email,address) values" +
	                        "(\""+name+"\",\""+psw+"\",\""+phone+"\",\""+email+"\",\""+address+"\")";
				 
				   System.out.println("get string");
				     // ״̬����ִ��SQL���
				   stmt.executeUpdate(sql);
				   System.out.println("successful insert");
				   //��flag��ͬ�û���Ϣһ��浽List���͵�back�У�Ȼ���ٷ���back
			   }

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
	
	
	
	
	
	
	
	//����û��ķ�����Ʒ��Ϣ�����getPublish��������������ݴ���������Ĳ��
	public Product getPublish(String brand,String type,double price,String phone,String other)
	{
		System.out.println("into getresponse");
		//���ռ��������ݲ��뵽���ݿ���String sql="insert into ���� values ('uerName','pwd')";//����������ִ�й��̡�public static void main(String[] args) {
		  Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs = null;
		  String sql=null;
		  int flag=1;
          Product nowProduct=null;
		  try 
		  {
			   conn=DBBean.getConnection();
			   // �������л�ȡ״̬
			   stmt = conn.createStatement();
			 
			   sql = "select * from product;";
			   rs = stmt.executeQuery(sql);//ִ��sql���
			   
			   //�ж��ֻ������Ƿ�Ϸ�
			   //һ���ֻ�������11λ�����������11λ������������ʽ�ж�
			   if(phone.length()==11)
			   {
				   String check="^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$"; //�ײ���Ч��������13112341234�ǲ��Ϸ���
				   Pattern regex = Pattern.compile(check);
				   Matcher matcher = regex.matcher(phone);
				   if(matcher.matches())
				    {
				    	flag=0;
				    }
			   }
			   else
				   //�������11λ��ֱ���ж�Ϊ���Ϸ�
				   flag=0;
			  
			  
			// ���ַ�����ʽ��дSQL���
			     
				   //�����Ƿ�����Ʒ��Ϣ�����Բ����ж���Ϣ�ĶԴ�ֱ�Ӳ��뵽���ݿ��оͿ�����
			   if(flag==1)
			   {  
				   sql="insert into product(brand,type,price,phone,other) values" +
	                        "(\""+brand+"\",\""+type+"\",\""+price+"\",\""+phone+"\",\""+other+"\")";
				 
				   System.out.println("get string");
				     // ״̬����ִ��SQL���
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
			   System.out.println("���ݲ�������");
			   e.printStackTrace();
		  }
		  
			
		//�ر����ݿ�
		  DBBean.clean(conn, stmt, rs);
		  System.out.println("successful return");
		return nowProduct;
		
	}
}
