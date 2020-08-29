package jdbcApp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;



public class demo_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties properties = new Properties();
		
		
		try {
			properties.load(new FileInputStream("db.prop"));
			
			String dri = properties.getProperty("dri");
			String url = properties.getProperty("url");
			String un = properties.getProperty("un");
			String pw = properties.getProperty("pw");
			
			Connection con = null;
			Statement stmt = null;
			
			try {
				Class.forName(dri);
				con = DriverManager.getConnection(url, un, pw);
				stmt = con.createStatement();
				
			
				Scanner input = new Scanner(System.in);
				System.out.println("Enter id you want to display : ");
				int id = input.nextInt();
				String sql = "SELECT * FROM students WHERE id ="+id;
				
				ResultSet rs = stmt.executeQuery(sql);
				
				
				if(rs.next())
				{
					int id2=rs.getInt(1);
					String name = rs.getString(2);
					String email = rs.getString(3);
					String mobile = rs.getString(4);
					System.out.println(id2+" "+name+" "+email+" "+mobile);
					
				}
				
				else
				{
					System.out.println("id is not correct");
				}
			
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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