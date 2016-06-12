package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.InsertData;

import entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		//用户注册有5个参数
		String name=request.getParameter("Name");
		String psw=request.getParameter("Password");
		String phone=request.getParameter("Phone");
		String email=request.getParameter("Email");
		String address=request.getParameter("Address");
		name = new String(name.getBytes("ISO-8859-1"), "UTF-8");  
		address = new String(address.getBytes("ISO-8859-1"), "UTF-8");  
		System.out.println(name+" "+psw+" "+phone+" "+email+" "+address);
		
		User newRegister=new User(name,psw,phone,email,address);
		InsertData userRegister=new InsertData();
		int result=userRegister.getRegister(name,psw,phone,email,address);
		System.out.println(result);
		
		switch(result)
		{
		case 1://用户信息没有错误
			request.setAttribute("register", newRegister);
		    request.getRequestDispatcher("resultRegister.jsp").forward(request,response);
		    break;
		case 2://没有填写用户名
			request.getRequestDispatcher("/register.html?error=没有填写用户名").forward(request,response);
			break;
		case 3://没有填写密码
			request.getRequestDispatcher("/register.html?error=没有填写密码").forward(request,response);
			break;
		case 4://和数据库已有的邮箱地址重复
			request.getRequestDispatcher("/register.html?error=邮箱地址重复").forward(request,response);
			break;
		case 5://邮箱地址不合法
			request.getRequestDispatcher("/register.html?error=邮箱不合法").forward(request,response);
			break;
		case 6://手机号码不合法
			request.getRequestDispatcher("/register.html?error=手机号码不合法").forward(request,response);
			break;
		case 0://和数据库已有的用户名重复
			request.getRequestDispatcher("/register.html?error=用户名重复").forward(request,response);
			break;
		}
 
	 }

	
	 
	
}
