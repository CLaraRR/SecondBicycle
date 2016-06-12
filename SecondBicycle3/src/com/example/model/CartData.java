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

public class CartData {		//������ݿ����û����ﳵҳ������ݻ�ͨ
	
//�ⲿ�ִ����������� UserCart ShowUserCart ShowCart �ֱ���ɶ����û���¼״̬�������ݿ�����ݻ�ͨ��
//��ʾ��¼״̬�û��Ĺ��ﳵ����   ��ʾ�ǵ�¼״̬�Ĺ��ﳵ����

	//����û���¼���ѹ��ﳵ����Ʒ������ݿ�
	public void UserCart(String productid,String num,HttpServletRequest request) throws SQLException
	{
		  Connection conn = null;	//���Ӷ���
		  Statement stmt = null;	//״̬����
		  ResultSet rs = null;		//�����
		  String sql=null;
          conn=DBBean.getConnection();
		try 
		  {
			   // �������л�ȡ״̬
			   stmt = conn.createStatement();
			   
			   //��product���ȡproduct����Ϣ
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
			   
			   //���¹��ﳵ���е����ݣ�������ò�Ʒ�����������������������������������Ϣ
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
				   System.out.println("��������");
			   }
			   else
			   {
				   System.out.println("into");
				   
				   sql="insert into usercart(username,productid,brand,type,num,price,totalprice,phone,other) values" +
	                        "(\""+username+"\",\""+productid+"\",\""+brand+"\",\""+type+"\",\""+num+"\",\""+price+"\",\""+price*nums+"\",\""+phone+"\",\""+other+"\")";
				   int result=stmt.executeUpdate(sql);
				   System.out.println("��������"+result);
			   }
				System.out.println("�ɹ�����Ʒ��ӽ���usercart��");
		  } 
		  catch (SQLException e)
		  {
			   System.out.println("���ݲ�������1");
			   e.printStackTrace();
		  }
	}
	
	//�鿴��ǰ�û����ﳵ��������Ʒ��Ϣ
	public HashMap showUserCart(HttpServletRequest request)
	{
		  Connection conn = null;//���Ӷ���
		  Statement stmt = null;//״̬����
		  ResultSet rs = null;//�����
		  String sql = null;//sql���
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
			   // �������л�ȡ״̬
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
			   System.out.println("���ݲ�������");
			   e.printStackTrace();
		  }
		return goodsList;
	}
	
	//�鿴�û�δ��¼ʱ���ﳵ��������Ʒ��Ϣ
	public HashMap showCart(String productid,String num)
	{
		
		  Connection conn = null;//���Ӷ���
		  Statement stmt = null;//״̬����
		  ResultSet rs = null;//�����
		  String sql = null;//sql���
		  int productid1=Integer.parseInt(productid);
		  HashMap goodsList=new HashMap();

          conn=DBBean.getConnection();
		try 
		  {
			   // �������л�ȡ״̬
			   stmt = conn.createStatement();
			   sql="select *from product where productid='"+productid1+"';";
//			   System.out.println("��ѯ�ɹ�");
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
			   System.out.println("���ݲ�������");
			   e.printStackTrace();
		  }
		return goodsList;
	}
	

}
