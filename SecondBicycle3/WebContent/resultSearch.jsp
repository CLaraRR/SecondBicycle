<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="entity.*" %>
<%@ page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
          	
					<h1 align="center" style="font-size:30px;">Search engine results page</h1>
                     <p style="text-align:left;position:relative;left:400px;"><br><br><br>
                     <%
                            List<Product> searchList= (List)request.getAttribute("searchResults");
                           for(int i=0; i<searchList.size(); i++){
                           Product product = searchList.get(i);
//                         System.out.println("("+medicine.getId()+")"+medicine.getName() + "\t" + medicine.getFunction());
                         
                         out.print("第"+(i+1)+"条记录："+"<br>");
                         out.print("商品ID："+product.getProductid()+"<br>");
                         out.print("品牌："+product.getBrand()+"<br>");
                         out.print("类型："+product.getType()+"<br>");
                         out.print("价格："+product.getPrice()+"<br>");
                         out.print("卖家联系电话："+product.getPhone()+"<br>");
                         out.print("商品描述："+product.getOther()+"<br><br>");
                     }
                      %>
                    </p>
					</div>
			  
				<div class="clear"></div>
			</div>
		</div><br><br><br><br><br><br>
     <jsp:include page="Footer.jsp" />
<div style="display:none"></div>
</body>
</html>