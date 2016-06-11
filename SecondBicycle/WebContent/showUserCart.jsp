<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="entity.*" %>
<jsp:useBean id="cart" class="com.example.model.CartData" scope="application"/> 
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery1.min.js"></script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!-- dropdown -->
<script src="js/jquery.easydropdown.js"></script>
</head>
<body>
    <div class="header-top">
			<div class="wrap"> 
			  <div class="header-top-left">
			  	   <div class="box">
   				      <select tabindex="4" class="dropdown">
							<option value="" class="label" value="">语言 :</option>
							<option value="1">English</option>
							<option value="2">French</option>
							<option value="3">German</option>
					  </select>
   				    </div>
   				    <div class="box1">
   				        <select tabindex="4" class="dropdown">
							<option value="" class="label" value="">货币 :</option>
							<option value="1">$ Dollar</option>
							<option value="2">€ Euro</option>
						</select>
   				    </div>
   				    <div class="clear"></div>
   			 </div>
			 <div class="cssmenu">
				<ul>
					<li class="active"><a href="login.jsp">我的账户</a></li> 
					<li><a href="checkout.html">我的收藏</a></li> 
					<li>
					<%
					HttpSession session1=request.getSession(false);
				    if(session1!=null)
				    {
				    %>
				    	<a href="showUserCart.jsp">
				    <%
				    }
				    else
				    {
				    %>
				    	<a href="showCart.jsp">
				    <%
				    }
				    %>
				           购物车</a></li>
					
					<li><a href="login.jsp">
					<%  /*String name=(String)request.getAttribute("styles");
					    out.print(name);*/
					    /*HttpSession session1=request.getSession(false);*/
					    if(session1!=null)
					    {
					       out.print("欢迎你！"+session1.getAttribute("user"));
					    }
					    else
					    {
					       out.print("登录");
					    }
					%>
					</a></li> 
					<li>
					<%
					/*HttpSession session2=request.getSession(false);*/
				    if(session1!=null)
				    {
					%>
					   <a href="LoginOutServlet" >注销</a>
					<%
					} 
				    else
				    {
				     %>
				    	<a href="register.jsp">注册</a>
				    <%
				    }
					%>
					
					</li>
				</ul>
			</div>
			<div class="clear"></div>
 		</div>
	 </div>
	<div class="header-bottom">
	    <div class="wrap">
			<div class="header-bottom-left">
				<div class="logo">
					<p style="font-size:35px;font-family:微软雅黑;">恋车网</p>
				</div>
				<div class="menu">
	            <ul class="megamenu skyblue">
			<li class="active grid"><a href="index.jsp">首页</a></li>
			<li><a class="color4" href="publish.jsp">我要卖车</a>
				
					
				</li>				
				<li><a class="color5" href="#">今日推荐</a>
				
				</li>
				<li><a class="color6" href="other.html">更多</a></li>
				<li><a class="color7" href="other.html">关于我们</a></li>
			</ul>
			</div>
		</div>
	   <div class="header-bottom-right">
         <div class="search">	  
				<input type="text" name="s" class="textbox" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
				<input type="submit" value="Subscribe" id="submit" name="submit">
				<div id="response"> </div>
		 </div>
	  <div class="tag-list">
	    <ul class="icon1 sub-icon1 profile_img">
			<li><a class="active-icon c1" href="#"> </a>
				<ul class="sub-icon1 list">
					<li><h3>sed diam nonummy</h3><a href=""></a></li>
					<li><p>Lorem ipsum dolor sit amet, consectetuer  <a href="">adipiscing elit, sed diam</a></p></li>
				</ul>
			</li>
		</ul>
		<ul class="icon1 sub-icon1 profile_img">
			<li><a class="active-icon c2" href="#"> </a>
				<ul class="sub-icon1 list">
					<li><h3>No Products</h3><a href=""></a></li>
					<li><p>Lorem ipsum dolor sit amet, consectetuer  <a href="">adipiscing elit, sed diam</a></p></li>
				</ul>
			</li>
		</ul>
	    <ul class="last"><li><a href="#">购物车(0)</a></li></ul>
	  </div>
    </div>
     <div class="clear"></div>
     </div>
	</div>
        <div class="login">
          	
					<h1 align="center" style="font-size:30px;">我的购物车</h1>
                        <p style="text-align:left;">
                        <br><br>
 <table width="95%" height="125" border="1">
    <tr>
      <th  width="15%" height="46" bgcolor="#FF8B53" scope="col">当前用户</th>
      <th width="15%" height="46" bgcolor="#FF8B53" scope="col">商品ID</th>
      <th  width="15%" height="46" bgcolor="#FF8B53" scope="col">描述</th>
      <th width="15%" height="46" bgcolor="#FF8B53" scope="col">品牌</th>
      <th width="15%" height="46" bgcolor="#FF8B53" scope="col">类型</th>
      <th width="15%" height="46" bgcolor="#FF8B53" scope="col">数量</th>
      <th  width="15%" bgcolor="#FF8B53" scope="col">单价</th>
      <th  width="15%" bgcolor="#FF8B53" scope="col">总价</th>
      <th  width="15%" bgcolor="#FF8B53" scope="col">操作</th>
      
    </tr>
<% 
HashMap cartdata=cart.showUserCart(request);
Iterator it=cartdata.keySet().iterator();
//out.print(cookie.getName());
while(it.hasNext())
{                      
	
	
	Product goods=(Product)cartdata.get(it.next());
	System.out.println(goods.getProductid());
	%>
	<tr>
	  <td align="center"><%=session1.getAttribute("user")%></td>
	  <td align="center"><%=goods.getProductid()%></td>
	  <td align="center"><%=goods.getOther()%></td>
	  <td align="center"><%=goods.getBrand()%></td>
      <td align="center"><%=goods.getType()%></td>
      <td align="center"><%=goods.getNum()%></td>
      <td align="center"><%=goods.getPrice()%></td>
      <td align="center"><%=goods.getPrice()*goods.getNum()%></td>
      <td align="center">
         <input type="button" align="right" value="下单" 
         onClick="location.href='resultOrder.jsp?productid=<%=goods.getProductid()%>'">
      </td>
     </tr>
  
<%
}
%>
 </table>

 </p>
					</div>
			  
				<div class="clear"></div>
			</div>
		</div>
		<br><br><br><br><br><br><br><br><br><br>
     <div class="footer">
		<div class="footer-top">
			<div class="wrap">
			  <div class="section group example">
				<div class="col_1_of_2 span_1_of_2">
					<ul class="f-list">
					  <li><img src="images/2.png"><span class="f-text">欢迎大家来选购~</span><div class="clear"></div></li>
					</ul>
				</div>
				<div class="col_1_of_2 span_1_of_2">
					<ul class="f-list">
					  <li><img src="images/3.png"><span class="f-text">如有任何问题PLEASE CALL US! 8888-88</span><div class="clear"></div></li>
					</ul>
				</div>
				<div class="clear"></div>
		      </div>
			</div>
		</div>
		<div class="footer-middle">
			<div class="wrap">
			 <div class="section group example">
			  <div class="col_1_of_f_1 span_1_of_f_1">
				 <div class="section group example">
				   <div class="col_1_of_f_2 span_1_of_f_2">
				      <h3>社交网站</h3>
						<script>(function(d, s, id) {
						  var js, fjs = d.getElementsByTagName(s)[0];
						  if (d.getElementById(id)) return;
						  js = d.createElement(s); js.id = id;
						  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
						  fjs.parentNode.insertBefore(js, fjs);
						}(document, 'script', 'facebook-jssdk'));</script>
						<div class="like_box">	
							<div class="fb-like-box" data-href="http://www.cssmoban.com/" data-colorscheme="light" data-show-faces="true" data-header="true" data-stream="false" data-show-border="true"></div>
						</div>
 				  </div>
				  <div class="col_1_of_f_2 span_1_of_f_2">
						<h3>友情链接</h3>
				       <div class="recent-tweet">
							<div class="recent-tweet-icon">
								<span> </span>
							</div>
							<div class="recent-tweet-info">
								<p> <a href="#">花生网</a></p>
							</div>
							<div class="clear"> </div>
					   </div>
					   <div class="recent-tweet">
							<div class="recent-tweet-icon">
								<span> </span>
							</div>
							<div class="recent-tweet-info">
								<p> <a href="#">香蕉网</a></p>
							</div>
							<div class="clear"> </div>
					  </div>
				</div>
				<div class="clear"></div>
		      </div>
 			 </div>
			 <div class="col_1_of_f_1 span_1_of_f_1">
			   <div class="section group example">
				 <div class="col_1_of_f_2 span_1_of_f_2">
				    <h3>更多资讯</h3>
						<ul class="f-list1">
						    <li><a href="#">首页</a></li>
				            <li><a href="#">捷安特</a></li>
				            <li><a href="#">宝马</a></li>
				             <li><a href="#">欧拜克</a></li>
				            <li><a href="#">当当 </a></li>
				            <li><a href="#">淘宝</a></li>
			         	</ul>
 				 </div>
				 <div class="col_1_of_f_2 span_1_of_f_2">
				   <h3>联系我们</h3>
						<div class="company_address">
					                <p>湖南省长沙市</p>
							   		<p>岳麓区</p>
							   		<p>天马学生公寓</p>
					   		<p>Phone:8888-888</p>
					 	 	<p>Email: <span>zhenmei@qq.com</span></p>
					   		
					   </div>
					   <div class="social-media">
						     <ul>
						        <li> <span class="simptip-position-bottom simptip-movable" data-tooltip="Google"><a href="#" target="_blank"> </a></span></li>
						        <li><span class="simptip-position-bottom simptip-movable" data-tooltip="Linked in"><a href="#" target="_blank"> </a> </span></li>
						        <li><span class="simptip-position-bottom simptip-movable" data-tooltip="Rss"><a href="#" target="_blank"> </a></span></li>
						        <li><span class="simptip-position-bottom simptip-movable" data-tooltip="Facebook"><a href="#" target="_blank"> </a></span></li>
						    </ul>
					   </div>
				</div>
				<div class="clear"></div>
		    </div>
		   </div>
		  <div class="clear"></div>
		    </div>
		  </div>
		</div>
		<div class="footer-bottom">
			<div class="wrap">
	            <div class="copy">
			           <p>Copyright &copy; 2014.Company name All rights reserved.<a target="_blank" href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
		        </div>
			  <div class="f-list2">
				<ul>
					<li class="active"><a href="about.html">About Us</a></li> |
					<li><a href="delivery.html">Delivery & Returns</a></li> |
					<li><a href="delivery.html">Terms & Conditions</a></li> |
					<li><a href="contact.html">Contact Us</a></li> 
				</ul>
			  </div>
				<div class="clear"></div>
		      </div>
			</div>
		</div>
<div style="display:none"></div>
</body>
</html>