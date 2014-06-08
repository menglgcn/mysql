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
		      
		      //������������һ��Ҳ��дΪ��Class.forName("com.mysql.jdbc.Driver");
		     Class.forName("com.mysql.jdbc.Driver").newInstance();
		      //������MySQL������
		       Connection conn = DriverManager.getConnection(url,user, pwd);
		      conn.setAutoCommit(false);
		      //ִ��SQL���
//		       Statement stmt = conn.createStatement();//��������������ִ��sql����
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
