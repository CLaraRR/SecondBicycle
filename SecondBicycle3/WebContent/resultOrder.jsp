<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="entity.*" %>
<jsp:useBean id="order" class="com.example.model.OrderData" scope="application"/> 
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
    <jsp:include page="Header-top.jsp" />
	<jsp:include page="Header-bottom.jsp" />
	
        <div class="login">
					<h1 align="center" style="font-size:30px;">订单信息</h1>
                        <p style="text-align:left;">
<table width="95%" height="125" border="1">
    <tr>
      <th width="15%" height="46" bgcolor="#FF8B53" scope="col">订单ID</th>
      <th  width="15%" height="46" bgcolor="#FF8B53" scope="col">用户名</th>
      <th  width="15%" height="46" bgcolor="#FF8B53" scope="col">描述</th>
      <th width="15%" height="46" bgcolor="#FF8B53" scope="col">商品ID</th>
      <th width="15%" height="46" bgcolor="#FF8B53" scope="col">品牌</th>
      <th width="15%" height="46" bgcolor="#FF8B53" scope="col">类型</th>
      <th width="15%" height="46" bgcolor="#FF8B53" scope="col">数量</th>
      <th  width="15%" bgcolor="#FF8B53" scope="col">单价</th>
      <th  width="15%" bgcolor="#FF8B53" scope="col">总价</th>

    </tr>                  
 <%
    String productid=request.getParameter("productid");
    order.createOrder(productid,request);
    Order newOrder=order.getOrder();
    pageContext.setAttribute("newOrder",newOrder);
 %>                       

  <tr>
      <td align="center">${newOrder.orderid}</td>
      <td align="center">${newOrder.username}</td>
      <td align="center">${newOrder.other}</td>
      <td align="center">${newOrder.productid}</td>
	  <td align="center">${newOrder.brand}</td>
      <td align="center">${newOrder.type}</td>
      <td align="center">${newOrder.num}</td>
      <td align="center">${newOrder.price}</td>
      <td align="center">${newOrder.totalprice }</td>

  </tr>                      
 </table>
					</div>
		<br><br><br><br><br><br><br><br><br><br>                  
     <jsp:include page="Footer.jsp" />
     
<div style="display:none"></div>
</body>
</html>