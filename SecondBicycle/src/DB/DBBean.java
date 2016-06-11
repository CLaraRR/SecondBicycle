package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBBean {
	//加载驱动
	public static Connection  getConnection()
	{
		  Connection conn = null;
		  try 
		  {
			  Class.forName("com.mysql.jdbc.Driver"); //加载mysql驱动
		  } 
		  catch (ClassNotFoundException e)
		  {
			   System.out.println("驱动加载错误");
			   e.printStackTrace();//打印出错详细信息
		  }
		  
		  try 
		  {
			   String url = "jdbc:mysql://localhost:3306/userdatabase";
			   String user = "root";
			   String password = "adt176367137";
			   // 获取与数据库的连接
			   conn = DriverManager.getConnection(url,user,password);
		  } 
		  catch (SQLException e)
		  {
			   System.out.println("数据库链接错误");
			   e.printStackTrace();
		  }
		  return conn;
	}
	
	
	//关闭数据库
	public  static void clean(Connection conn,Statement stmt, ResultSet rs)
	{
		try 
		  {
			   if(rs != null)
			   {
				    rs.close();
				    rs = null;
			   }
			   if(stmt != null)
			   {
				    stmt.close();
				    stmt = null;
			   }
			   if(conn != null) 
			   {
				    conn.close();
				    conn = null;
			   }
		  }
		  catch(Exception e)
		  {
			   System.out.println("数据库关闭错误");
			   e.printStackTrace();
		  }
	}


	
}
