package jdbcApp;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// INSERT SQL command with JDBC
// Obtain DB creds from properties file.

public class demo_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("db.prop"));
			
			String dri = properties.getProperty("dri");
			String url = properties.getProperty("url");
			String un = properties.getProperty("un");
			String pw =properties.getProperty("pw");
			
			Connection con = null;
			Statement stmt = null;
			
			try {
				Class.forName(dri);
				con = DriverManager.getConnection(url, un, pw);
				stmt = con.createStatement();
				
				String sql = "INSERT INTO student VALUES (5,'Balu','balu@gm.com','956045')";
				
				int n = stmt.executeUpdate(sql);
				
				if(n==1) {
					System.out.println("Inserted successfully");
				}
				else {
					System.out.println("Insertion failed");
				}
				
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


