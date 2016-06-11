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
品牌: Giant/捷安特       车架材质: 铝合金      轮径尺寸: 26英寸
颜色分类: 21速标配+无锁死前叉《黑红  
速别: 21速 24速 27速        货号: ATX777      尺寸: 26英寸x17英寸
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
     	<!--<p class="m_text">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.</p>-->
     </div>
     <div class="toogle">
     	<h3 class="m_3">了解更多</h3>
        <img src="images/know_more20.jpg"><img>
        
     	<!--<p class="m_text">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.</p>-->
     </div>
      </div>
			<div class="rsingle span_1_of_single">
				<!--<h5 class="m_1">Categories</h5>
					<select class="dropdown" tabindex="8" data-settings='{"wrapperClass":"metro"}'>
						<option value="1">Mens</option>
						<option value="2">Sub Category1</option>
						<option value="3">Sub Category2</option>
						<option value="4">Sub Category3</option>
					</select>
					<select class="dropdown" tabindex="8" data-settings='{"wrapperClass":"metro"}'>
						<option value="1">Womens</option>
						<option value="2">Sub Category1</option>
						<option value="3">Sub Category2</option>
						<option value="4">Sub Category3</option>
					</select>
					<ul class="kids">
						<li><a href="#">Kids</a></li>
						<li class="last"><a href="#">Glasses Shop</a></li>
					</ul>-->
                   <section  class="sky-form">
					<h4>价格区间</h4>
						<div class="row row1 scroll-pane">
							<div class="col col-4">
								<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>100 - 150</label>
							</div>
							<div class="col col-4">
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>150 - 200</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>200 - 250</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>250 - 300</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>300 - 350</label>
								<label class="checkbox"><input type="checkbox" name="checkbox" ><i></i>350 - 400</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>400 - 450</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>450 - 500</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>500 - 550</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>550 - 600</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>600 - 650</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>650 - 700</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>700 - 750</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>750 - 800</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>800 - 1000</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>1000以上</label>	
							</div>
						</div>
		        </section>
		       <section  class="sky-form">
					<h4>品牌</h4>
						<div class="row row1 scroll-pane">
							<div class="col col-4">
								<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>捷安特</label>
							</div>
							<div class="col col-4">
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>宝马</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>永久</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>凤凰</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>美利达</label>
								<label class="checkbox"><input type="checkbox" name="checkbox" ><i></i>大行</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>欧拜克</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>奥迪</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>喜德盛</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>路虎</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>英菲力克</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>飞鸽</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>升特</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>君圣</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>蓝克雷斯</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>其他</label>	
							</div>
						</div>
		       </section>
		       <section  class="sky-form">
					<h4>类型</h4>
						<div class="row row1 scroll-pane">
							<div class="col col-4">
								<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>迷你车</label>
							</div>
							<div class="col col-4">
							    <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>山地车</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>折叠车</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>公路车</label>
								<label class="checkbox"><input type="checkbox" name="checkbox" ><i></i>死飞</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>休闲车</label>
								<label class="checkbox"><input type="checkbox" name="checkbox" ><i></i>更多</label>
						    </div>
						</div>
		       </section>
		       <section  class="sky-form">
					<h4>轮径尺寸</h4>
						<div class="row row1 scroll-pane">
							<div class="col col-4">
								<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>16英寸</label>
							</div>
							<div class="col col-4">
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>20英寸</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>22英寸</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>24英寸</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>26英寸</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>27.5英寸</label>
							</div>
						</div>
		       </section>
		       <section  class="sky-form">
					<h4>新旧程度</h4>
						<div class="row row1 scroll-pane">
							<div class="col col-4">
								<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>完全新</label>
							</div>
							<div class="col col-4">
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>九成新</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>八成新</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>七成新</label>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>七成以下</label>
							</div>
						</div>
		       </section>
		       <section  class="sky-form">
					<h4>车身颜色</h4>
						<ul class="color-list">
							<li><a href="#"> <span class="color1"> </span><p class="red">红</p></a></li>
							<li><a href="#"> <span class="color2"> </span><p class="red">绿</p></a></li>
							<li><a href="#"> <span class="color3"> </span><p class="red">蓝</p></a></li>
							<li><a href="#"> <span class="color4"> </span><p class="red">黄</p></a></li>
							<li><a href="#"> <span class="color5"> </span><p class="red">粉</p></a></li>
							<li><a href="#"> <span class="color6"> </span><p class="red">橙</p></a></li>
							<li><a href="#"> <span class="color7"> </span><p class="red">灰</p></a></li>
					   </ul>
		       </section>
		       <script src="js/jquery.easydropdown.js"></script>
		      </div
		      ><div class="clear"></div>
			</div>
			 <div class="clear"></div>
		   </div>
		</div>
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
					  <li><img src="images/3.png"><span class="f-text">如有任何问题Please Call us! 8888-888 </span><div class="clear"></div></li>
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
                            <br>
								<p><a href="#">花生网</a></p>
							</div>
							<div class="clear"> </div>
					   </div>
					   <div class="recent-tweet">
							<div class="recent-tweet-icon">
								<span> </span>
							</div>
							<div class="recent-tweet-info">
                            <br>
								<p><a href="#">香蕉网</a></p>
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
						    <li><a href="#">首页 </a></li>
				            <li><a href="#">捷安特</a></li>
				            <li><a href="#">宝马</a></li>
				             <li><a href="#">欧拜克 </a></li>
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
					   		<p>Fax: (000) 000 00 00 0</p>
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