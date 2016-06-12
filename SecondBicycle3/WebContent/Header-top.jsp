 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div class="header-top">
	   <div class="wrap"> 
			  <div class="header-top-left">
			  	   <div class="box">
   				      <select tabindex="4" class="dropdown">
							<option value="" class="label" value="">语言 :</option>
							<option value="1">英语</option>
							<option value="2">韩语</option>
							<option value="3">日语</option>
					  </select>
   				    </div>
   				    <div class="box1">
   				        <select tabindex="4" class="dropdown">
							<option value="" class="label" value="">货币 :</option>
							<option value="1">人民币</option>
							<option value="2">美元</option>
						</select>
   				    </div>
   				    <div class="clear"></div>
   			 </div>
			 <div class="cssmenu">
				<ul>
					<li class="active"><a href="login.jsp">我的账户</a></li> 
					<li><a href="checkout.html">我的收藏</a></li> 
					<li>
					<c:choose>
						<c:when test="${sessionScope.user eq null}">
					    	<a href="showUserCart.jsp">购物车</a>
				    	</c:when>
				    	<c:otherwise>
				    		<a href="showCart.jsp">购物车</a>
				    	</c:otherwise>
				   </c:choose>
				    </li>
					
					<li><a href="login.jsp">
					<c:choose>
					<c:when test="${sessionScope.user ne null }">
						<c:out value="欢迎你  ${sessionScope.user}" />
					</c:when>
					<c:otherwise>
					   	<c:out value="登录" />
					</c:otherwise>
					</c:choose>
					</a></li> 
					<li>
					<c:choose>
					<c:when test="${sessionScope.user ne null}">
					   <a href="LoginOutServlet" >注销</a>
					</c:when>
					<c:otherwise>
				    	<a href="register.jsp">注册</a>
				    </c:otherwise>
					</c:choose>
					</li>
						
				</ul>
			</div>
			<div class="clear"></div>
 		</div>
	</div>