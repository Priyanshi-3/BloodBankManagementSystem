package bb.dbtask;
import java.sql.*;
public class CrudOperation 
{
	private static Connection con;
	public static Connection createConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","root");
		}
		catch(ClassNotFoundException | SQLException cse)
		{
			System.out.println(cse);
					
		}
		return con;
	}
	public static void main(String[] args) {
		Connection cn=createConnection();
		System.out.println(cn);
	}
}
