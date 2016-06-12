package com.example.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.HttpCookie;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.model.CartData;

/**
 * Servlet implementation class Select
 */
@WebServlet("/Select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Select() {
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
		

		String productID=request.getParameter("productid");
		String num=request.getParameter("num");
		System.out.println("productID:"+productID+" "+"num:"+num);
		
		Cookie[] cookies = request.getCookies();
	
		if(cookies!=null)//如果cookies不为空，然后考虑用户登录和未登录两种情况
		{
			System.out.println("cookies不为空");
			
			if(!getUserInSession(request))//如果用户未登录，则将用户的购物车信息写到cookie中
			{
				System.out.println("用户未登录1");
				boolean flag=false;//默认情况已有的cookies中没有相应的cookie
				for(int i=0;i<cookies.length;i++)
				{
					if(!isProductID(cookies[i].getName()))
						continue;
					Cookie cookie=cookies[i];
					System.out.println("第"+i+"个cookie:"+cookie.getName()+" "+cookie.getValue());
					
					if(cookie.getName().equals(productID))//如果已有的cookies中有相应的cookie，就进行更新操作(对原有的cookie进行覆盖)
					{
						System.out.println("已有的cookies中有相应的cookie："+cookie.getValue());
						
						flag=true;
						Cookie newCookie=new Cookie("bike"+productID,num);
						newCookie.setMaxAge(20*60);
						response.addCookie(newCookie);
						
						System.out.println("更新后的cookie:"+newCookie.getName()+" "+newCookie.getValue());
						
						response.sendRedirect("showCart.jsp");  
					}
					
				}
				if(!flag)//如果已有的cookies中没有相应的cookie
				{
					System.out.println("已有的cookies中没有相应的cookie");
					//建立一个新cookie来存放商品信息
					Cookie newCookie=new Cookie("bike"+productID,num);
					newCookie.setMaxAge(20*60);
					response.addCookie(newCookie);
					System.out.println("添加一个cookie："+newCookie.getName()+" "+newCookie.getValue());
					
					response.sendRedirect("showCart.jsp");  
				}
			}
			else //如果用户已登录,持久化购物车信息（直接存进数据库）
			{
				System.out.println("用户已登录1");
				CartData goods=new CartData();
				try {
					goods.UserCart(productID,num,request);
					System.out.println("直接添加 ");
					
					
					for(int i=0;i<cookies.length;i++)
					{
						if(!isProductID(cookies[i].getName()))
							continue;
						Cookie cookie=cookies[i];
						System.out.println("第"+i+"个cookie:"+cookie.getName()+" "+cookie.getValue());
						goods.UserCart(cookie.getName().substring(4, 5),cookie.getValue(),request);
						System.out.println("从cookie添加");	
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect("showUserCart.jsp");  
			}
			
		}
		else//cookies为空
		{
			System.out.println("cookies为空！");
			//建立一个新cookie来存放商品信息
			Cookie newCookie=new Cookie("bike"+productID,num);
			newCookie.setMaxAge(20*60);
			response.addCookie(newCookie);
			
			System.out.println("添加一个cookie："+newCookie.getName()+" "+newCookie.getValue());

			response.sendRedirect("showCart.jsp");  
		}

	}
	public Boolean getUserInSession(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session.getAttribute("user") != null)//用户已登录
		{
			System.out.println("用户已登录");
			return true;
		}
		else
		{
			System.out.println("用户未登录");
			return false;
		}
		
	}
	
	private boolean isProductID(String s){
		switch(s){
			case "bike0":
			case "bike1":
			case "bike2":
			case "bike3":
			case "bike4":
			case "bike5":
			case "bike6":
			case "bike7":
			case "bike8":
			case "bike9":return true;
		}
		return false;
	}

}
