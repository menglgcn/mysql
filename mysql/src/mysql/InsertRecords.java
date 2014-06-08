package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertRecords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try
		    {
		      String url="jdbc:mysql://localhost/test";
		      String user="root";
		      String pwd="zaq12wsx";
		      
		      //加载驱动，这一句也可写为：Class.forName("com.mysql.jdbc.Driver");
		     Class.forName("com.mysql.jdbc.Driver").newInstance();
		      //建立到MySQL的连接
		       Connection conn = DriverManager.getConnection(url,user, pwd);
		      conn.setAutoCommit(false);
		      //执行SQL语句
//		       Statement stmt = conn.createStatement();//创建语句对象，用以执行sql语言
//		      ResultSet rs = stmt.executeQuery("select * from test");
		      PreparedStatement ps = conn
		    		     .prepareStatement("insert into test(name, age) values(?,?)");
		      
		      
		      for(int i=0;i<5000;i++){
		    	  ps.setString(1,Utils.generateStr());
		    	  ps.setInt(2, Utils.generateAge());
		    	 ps.addBatch();
		      }
		      int[] result = ps.executeBatch();
		      conn.commit();
		      conn.setAutoCommit(true);
	      conn.close();
		    }
		    catch (Exception ex)
		    {
		      System.out.println("Error : " + ex.toString());
		    }
		
		
	}

}
