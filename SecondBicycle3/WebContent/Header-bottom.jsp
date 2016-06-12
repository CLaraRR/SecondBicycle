<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	<div class="header-bottom">
	    <div class="wrap">
			<div class="header-bottom-left">
				<div class="logo">
                    <p style="font-size:35px;font-family:微软雅黑;">恋车网</p>
					<!--<a href="index.html"><img src="images/logo.png" alt=""/></a>-->
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
	   <form method="POST" action="Search.do">
         <div class="search">	  
				<input type="text" name="search" class="textbox" value="Search" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Search';}">
				<input type="submit" value="Subscribe" id="submit" name="submit">
				<div id="response"> </div>
		 </div>
		 </form>
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
	    <ul class="last"><li><a href="#">购物车</a></li></ul>
	  </div>
    </div>
     <div class="clear"></div>
     </div>
	</div>