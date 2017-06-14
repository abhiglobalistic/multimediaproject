package multimedia;

import java.sql.*;


public class connection {

	public static void main(String[] args) {
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl12c","system","oracle");
			Statement st = con.createStatement();
			String sql="select * from aa";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			System.out.println("AT database:"+rs.getInt(1));
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("hello");
			System.out.println(e);
		}
	}

}
