package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.model.InsertData;

import entity.Product;

/**
 * Servlet implementation class Publish
 */
@WebServlet("/Publish")
public class Publish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Publish() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		if(session==null)
		{
			//用户没登陆
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		else
		{
			//用户已登陆
			String brand=request.getParameter("Brand");
			String type=request.getParameter("Type");
			String price=request.getParameter("Price");
			String phone=request.getParameter("Phone");
			String other=request.getParameter("Other");
			brand = new String(brand.getBytes("ISO-8859-1"), "UTF-8"); 
			type = new String(type.getBytes("ISO-8859-1"), "UTF-8"); 
			other = new String(other.getBytes("ISO-8859-1"), "UTF-8"); 
			double price1=Double.parseDouble(price);
			
			System.out.println(brand);
			InsertData newPublish=new InsertData();
			System.out.println(brand+" "+type+" "+price+" "+phone+" "+other);
			Product newProduct=newPublish.getPublish(brand,type,price1,phone,other);
			
			if(newProduct!=null)
			{
		        request.setAttribute("publish",newProduct );
//				RequestDispatcher view=request.getRequestDispatcher("resultPublish.jsp");
				request.getRequestDispatcher("resultPublish.jsp").forward(request,response);
			}
			else 
			{
				request.getRequestDispatcher("/publish.jsp?error=手机号码不合法").forward(request,response);
			}
		}
		
	}
}
