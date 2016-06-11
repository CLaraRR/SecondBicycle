package com.example.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginOutServlet
 */
@WebServlet("/LoginOutServlet")
public class LoginOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);//防止创建Session  
        if(session == null){  
        	System.out.println("当前没有回话");
            response.sendRedirect("login.jsp");  
            return;  
        }  
         session.invalidate();
//        session.removeAttribute("user");  
        System.out.println("会话删除");
        Cookie[] cookies = request.getCookies();
		   if(cookies==null)
		   {
			   System.out.println("no cookie");
		   }
		   else
		   {
			   
			   cookies[0].setValue(null);
//			   Cookie cookie = new Cookie(cookies[i].getName(), null);
//               cookie.setMaxAge(0);
//               cookie.setPath(path);//根据你创建cookie的路径进行填写
//               response.addCookie(cookie);
			   System.out.println("there is a cookie:"+cookies[0].getName()+" "+cookies[0].getValue());
		   }
        response.sendRedirect("index.html");  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
