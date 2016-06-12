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
	
		if(cookies!=null)//���cookies��Ϊ�գ�Ȼ�����û���¼��δ��¼�������
		{
			System.out.println("cookies��Ϊ��");
			
			if(!getUserInSession(request))//����û�δ��¼�����û��Ĺ��ﳵ��Ϣд��cookie��
			{
				System.out.println("�û�δ��¼1");
				boolean flag=false;//Ĭ��������е�cookies��û����Ӧ��cookie
				for(int i=0;i<cookies.length;i++)
				{
					if(!isProductID(cookies[i].getName()))
						continue;
					Cookie cookie=cookies[i];
					System.out.println("��"+i+"��cookie:"+cookie.getName()+" "+cookie.getValue());
					
					if(cookie.getName().equals(productID))//������е�cookies������Ӧ��cookie���ͽ��и��²���(��ԭ�е�cookie���и���)
					{
						System.out.println("���е�cookies������Ӧ��cookie��"+cookie.getValue());
						
						flag=true;
						Cookie newCookie=new Cookie("bike"+productID,num);
						newCookie.setMaxAge(20*60);
						response.addCookie(newCookie);
						
						System.out.println("���º��cookie:"+newCookie.getName()+" "+newCookie.getValue());
						
						response.sendRedirect("showCart.jsp");  
					}
					
				}
				if(!flag)//������е�cookies��û����Ӧ��cookie
				{
					System.out.println("���е�cookies��û����Ӧ��cookie");
					//����һ����cookie�������Ʒ��Ϣ
					Cookie newCookie=new Cookie("bike"+productID,num);
					newCookie.setMaxAge(20*60);
					response.addCookie(newCookie);
					System.out.println("���һ��cookie��"+newCookie.getName()+" "+newCookie.getValue());
					
					response.sendRedirect("showCart.jsp");  
				}
			}
			else //����û��ѵ�¼,�־û����ﳵ��Ϣ��ֱ�Ӵ�����ݿ⣩
			{
				System.out.println("�û��ѵ�¼1");
				CartData goods=new CartData();
				try {
					goods.UserCart(productID,num,request);
					System.out.println("ֱ����� ");
					
					
					for(int i=0;i<cookies.length;i++)
					{
						if(!isProductID(cookies[i].getName()))
							continue;
						Cookie cookie=cookies[i];
						System.out.println("��"+i+"��cookie:"+cookie.getName()+" "+cookie.getValue());
						goods.UserCart(cookie.getName().substring(4, 5),cookie.getValue(),request);
						System.out.println("��cookie���");	
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect("showUserCart.jsp");  
			}
			
		}
		else//cookiesΪ��
		{
			System.out.println("cookiesΪ�գ�");
			//����һ����cookie�������Ʒ��Ϣ
			Cookie newCookie=new Cookie("bike"+productID,num);
			newCookie.setMaxAge(20*60);
			response.addCookie(newCookie);
			
			System.out.println("���һ��cookie��"+newCookie.getName()+" "+newCookie.getValue());

			response.sendRedirect("showCart.jsp");  
		}

	}
	public Boolean getUserInSession(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session.getAttribute("user") != null)//�û��ѵ�¼
		{
			System.out.println("�û��ѵ�¼");
			return true;
		}
		else
		{
			System.out.println("�û�δ��¼");
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
