package jdbcApp;

//Using properties file to obtain db credentials

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class demo_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("db.prop"));

			String dri = properties.getProperty("dri");
			String url = properties.getProperty("url");
			String un = properties.getProperty("un");
			String pw = properties.getProperty("pw");

			try {
				Class.forName(dri);
				Connection con = DriverManager.getConnection(url, un, pw);
				Statement stmt = con.createStatement();
				String sql = "SELECT * FROM students";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String dob = rs.getString("dob");
					String email = rs.getString("email");
					String mobile = rs.getString("mobile");
					System.out.println(id + " " + name + " " + dob + " " + email + " " + mobile);

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
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}