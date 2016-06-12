<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page session="false"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Single:: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
<script src="js/jquery1.min.js"></script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script type="text/javascript" src="js/jquery.jscrollpane.min.js"></script>
		<script type="text/javascript" id="sourcecode">
			$(function()
			{
				$('.scroll-pane').jScrollPane();
			});
		</script>
<!-- start details -->
<script src="js/slides.min.jquery.js"></script>
   <script>
		$(function(){
			$('#products').slides({
				preload: true,
				preloadImage: 'img/loading.gif',
				effect: 'slide, fade',
				crossfade: true,
				slideSpeed: 350,
				fadeSpeed: 500,
				generateNextPrev: true,
				generatePagination: false
			});
		});
	</script>
	<!-- start zoom -->
	<link rel="stylesheet" href="css/zoome-min.css" />
	<script type="text/javascript" src="js/zoome-e.js"></script>
	<script type="text/javascript">
		$(function(){
		$('#img1').zoome({showZoomState:true,magnifierSize:[250,250]});
	});
	</script>		
</head>
<body>
       <jsp:include page="Header-top.jsp" />
       <jsp:include page="Header-bottom.jsp" />
<div class="mens">    
  <div class="main">
     <div class="wrap">
     	<ul class="breadcrumb breadcrumb__t"><a class="home" href="#">主页</a> / <a href="#">捷安特</a> / 山地自行车</ul>
		<div class="cont span_2_of_3">
		  	<div class="grid images_3_of_2">
						<div id="container">
							<div id="products_example">
								<div id="products">
									<div class="slides_container">
									        <a href="#"><img style="width:295px;height:295px;"class="a" id="img2" src="images/img2.jpg" alt="" rel="images/img1.jpg" /></a>
											
									</div>
									<ul class="pagination">
										<li><a href="#"><img src="images/img2.jpg" width="s-img" alt="1144953 3 2x"></a></li>
										
										<div class="clear"></div>
									</ul>
								</div>
							</div>
						</div>
	            </div>
		         <div class="desc1 span_3_of_2">
		         	<h3 class="m_3" >新款组装捷按特山地自行车21/24/27速26铝合金双碟刹可锁死变速车</h3>
		             <p class="m_5">九成新300 <span class="reducedfrom">原价499</span> <a href="#">click for offer</a></p>
		         	 <div class="btn_form">
						<form method="POST" action="Select.do">
						    <input type="hidden" name="productid" value="2">
						    <input type="text" name="num">
							<input type="submit" value="buy" title="">
						</form>
					 </div>
					<span class="m_link"><a href="#">登陆就可以收藏哟~</a> </span>
				     <p class="m_text2"><pre>
产品参数：
品牌: Giant/捷安特    车架材质: 铝合金    轮径尺寸: 26英寸
颜色分类: 21速标配+无锁死前叉《黑红  
速别: 21速 24速 27速       货号: ATX777 尺寸: 26英寸x17英寸
制动系统: 双碟刹         车架类型: 硬车架    前叉类型: 油簧叉
(弹簧回弹/震油阻尼)</pre> </p>
			     </div>
			   <div class="clear"></div>	
	    <div class="clients">
	    <h3 class="m_3">还有这些同类型产品正在热卖中哦~</h3>
		 <ul id="flexiselDemo3">
			<li><img src="images/img2.jpg" /><p>捷安特 九成新400</p></li>
			<li><img src="images/img3.jpg" /><p>捷安特 八成新300</p></li>
			<li><img src="images/img4.jpg" /><p>捷安特 九成新388</p></li>
			<li><img src="images/img5.jpg" /><p>捷安特 八成新298</p></li>
			<li><img src="images/img6.jpg" /><p>捷安特 七成新259</p></li>
		 </ul>
	<script type="text/javascript">
		$(window).load(function() {
			$("#flexiselDemo1").flexisel();
			$("#flexiselDemo2").flexisel({
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		
			$("#flexiselDemo3").flexisel({
				visibleItems: 5,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	</script>
	<script type="text/javascript" src="js/jquery.flexisel.js"></script>
     </div>
     <div class="toogle">
     	<h3 class="m_3">产品描述</h3>
        <img src="images/pro_des20.jpg"><img>
        <img src="images/pro_des21.jpg"><img>
        <img src="images/pro_des22.jpg"><img>
        <img src="images/pro_des23.jpg"><img>
        <img src="images/pro_des24.jpg"><img>
        <img src="images/pro_des25.jpg"><img>
        <img src="images/pro_des26.jpg"><img>
     </div>
     <div class="toogle">
     	<h3 class="m_3">了解更多</h3>
        <img src="images/know_more20.jpg"><img>
      </div>
      </div>
     <jsp:include page="Selection.jsp" />
	<div class="clear"></div>
</div>
	<div class="clear"></div>
	</div>
</div>
	<jsp:include page="Footer.jsp" />
<div style="display:none"></div>
</body>
</html>