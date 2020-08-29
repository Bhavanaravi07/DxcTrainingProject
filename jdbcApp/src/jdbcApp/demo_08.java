package jdbcApp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class demo_08 {

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
			PreparedStatement pstmt = null;
			
			try {
				Class.forName(dri);
				con = DriverManager.getConnection(url, un, pw);
				String sql = "INSERT INTO students VALUES(?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				
				Scanner in = new Scanner(System.in);
				
				System.out.println("Enter id : ");
				int id = in.nextInt();
				
				System.out.println("Enter name : ");
				String name = in.next();
				
				System.out.println("Enter Email : ");
				String Email = in.next();
				
				System.out.println("Enter mobile : ");
				String mobile = in.next();
				
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, Email);
				pstmt.setString(4, mobile);
						
						
				if(1==pstmt.executeUpdate()) {
					System.out.println("Inserted successfully");
				}
				else {
					System.out.println("Failed to insert");
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
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					con.close();
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
