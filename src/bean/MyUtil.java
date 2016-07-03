package bean;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class MyUtil
{

	public MyUtil()
	{

	}
	
	
    public static void closeResultSet(ResultSet rs) 
    {
    	if(rs!=null){
    		try
			{
				rs.close();
				rs=null;
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
    	}
    }
    public static void closePrepareStatement(PreparedStatement pstmt) 
    {
    	if(pstmt!=null){
    		try
			{
    			pstmt.close();
    			pstmt=null;
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
    	}
    }
    public static void closeStatement(Statement stmt) 
    {
    	if(stmt!=null){
    		try
			{
    			stmt.close();
    			stmt=null;
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
    	}
    }
    public static void closeConnection(Connection con) 
    {
    	if(con!=null){
    		try
			{
    			con.close();
    			con=null;
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
    	}
    }
    
	public static Connection getDBConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); // ����MYSQL JDBC�����
		} catch (Exception e)
		{
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		Connection connect = null;
		try
		{
			connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/datas", "root",
				"123456");
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, "无法连接数据库", "警告", JOptionPane.OK_OPTION);
		}
		
		return connect;
	}

}
