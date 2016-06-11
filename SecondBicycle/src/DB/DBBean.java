package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBBean {
	//��������
	public static Connection  getConnection()
	{
		  Connection conn = null;
		  try 
		  {
			  Class.forName("com.mysql.jdbc.Driver"); //����mysql����
		  } 
		  catch (ClassNotFoundException e)
		  {
			   System.out.println("�������ش���");
			   e.printStackTrace();//��ӡ������ϸ��Ϣ
		  }
		  
		  try 
		  {
			   String url = "jdbc:mysql://localhost:3306/userdatabase";
			   String user = "root";
			   String password = "adt176367137";
			   // ��ȡ�����ݿ������
			   conn = DriverManager.getConnection(url,user,password);
		  } 
		  catch (SQLException e)
		  {
			   System.out.println("���ݿ����Ӵ���");
			   e.printStackTrace();
		  }
		  return conn;
	}
	
	
	//�ر����ݿ�
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
			   System.out.println("���ݿ�رմ���");
			   e.printStackTrace();
		  }
	}


	
}
