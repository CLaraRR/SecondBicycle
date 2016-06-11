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
		//�û�ע����5������
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
		case 1://�û���Ϣû�д���
			request.setAttribute("register", newRegister);
		    request.getRequestDispatcher("resultRegister.jsp").forward(request,response);
		    break;
		case 2://û����д�û���
			request.getRequestDispatcher("/register.html?error=û����д�û���").forward(request,response);
			break;
		case 3://û����д����
			request.getRequestDispatcher("/register.html?error=û����д����").forward(request,response);
			break;
		case 4://�����ݿ����е������ַ�ظ�
			request.getRequestDispatcher("/register.html?error=�����ַ�ظ�").forward(request,response);
			break;
		case 5://�����ַ���Ϸ�
			request.getRequestDispatcher("/register.html?error=���䲻�Ϸ�").forward(request,response);
			break;
		case 6://�ֻ����벻�Ϸ�
			request.getRequestDispatcher("/register.html?error=�ֻ����벻�Ϸ�").forward(request,response);
			break;
		case 0://�����ݿ����е��û����ظ�
			request.getRequestDispatcher("/register.html?error=�û����ظ�").forward(request,response);
			break;
		}
 
	 }

	
	 
	
}
