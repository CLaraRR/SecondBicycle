package com.example.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.example.model.SearchInfo;
//import com.example.model.SearchInfo;


import entity.Product;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
		String content=request.getParameter("search");
		content = new String(content.getBytes("ISO-8859-1"), "UTF-8"); 
		
		SearchInfo luceneProcess = new SearchInfo("D:/index");
        String [] fields = {"brand","type","other"};
        List<Product> list = luceneProcess.search(fields,content);
		

        
        for(int i=0; i<list.size(); i++){
            Product product = list.get(i);  
            System.out.println("第"+(i+1)+"条记录：");
            System.out.println("商品ID："+product.getProductid());
            System.out.println("品牌："+product.getBrand());
            System.out.println("类型："+product.getType());
            System.out.println("价格："+product.getPrice());
            System.out.println("卖家联系电话："+product.getPhone());
            System.out.println("商品描述："+product.getOther());
        }
		
	    request.setAttribute("searchResults", list);
	    RequestDispatcher view=request.getRequestDispatcher("resultSearch.jsp");
	    view.forward(request,response);
		
	}

}
