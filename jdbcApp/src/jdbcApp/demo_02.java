package jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demo_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dri = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/students";
		String un = "root";
		String pw = "root";
		
		try {
			Class.forName(dri);
			Connection con = DriverManager.getConnection(url, un, pw);
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM students";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getNString("email");
				String mobile = rs.getString("mobile");
				System.out.println(id+" "+name+" "+email+" "+mobile);
				}
			rs.close();
			stmt.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


}



	}

