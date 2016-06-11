package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.model.InsertData;
import com.example.model.SearchData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Servlet implementation class Register
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String name=request.getParameter("Name");
		name = new String(name.getBytes("ISO-8859-1"), "UTF-8"); 
		String psw=request.getParameter("Password");
		SearchData dt=new SearchData();
		
		System.out.println(name+" "+psw);
		//调用SearchData类中的getData()得到登陆情况（成功1，密码错误2，没有用户名0）
		int result=dt.getData(name,psw);
        if(result==1)
        {
		   HttpSession session=request.getSession();
		   System.out.println("用户登录成功，创建一个新的session");
		   if(session!=null)
		   {
			   System.out.println("创建成功");
			   //把用户名作为会话属性存储
			   session.setAttribute("user", name);
			   
			   System.out.println(session.getAttribute("user"));
			   Cookie[] cookies = request.getCookies();
			   if(cookies==null)
			   {
				   System.out.println("no cookie");
			   }
			   else
			   {
				   System.out.println("there is a cookie:"+cookies[0].getName()+" "+cookies[0].getValue());
			   }
			   
		       request.setAttribute("styles", name);
		       RequestDispatcher view=request.getRequestDispatcher("index.jsp");
		       view.forward(request,response);
		   }
		   else
		   {
			   System.out.println("创建不成功");
		   }
        }
        else if(result==0)
        {
            RequestDispatcher view=request.getRequestDispatcher("/login.jsp?error=没有用户名");
    		view.forward(request,response);
        }
        else if(result==2)
        {
            RequestDispatcher view=request.getRequestDispatcher("/login.jsp?error=密码错误");
    		view.forward(request,response);
        } 
	 }

	
	 
	
}
