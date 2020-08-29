package jdbcApp;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class insertvalues {

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
			
			Class.forName(dri);
			con = DriverManager.getConnection(url, un, pw);
			stmt = con.createStatement();
			
		
			Scanner input = new Scanner(System.in);
			
			System.out.println("Enter id :");
			int id=input.nextInt();
			System.out.println("Enter  name :");
			String name=input.next();
			System.out.println("Enter sub1 marks : ");
			int sub1=input.nextInt();
			System.out.println("Enter sub2 marks : ");
			int sub2=input.nextInt();
			System.out.println("Enter sub3 marks : ");
			int sub3=input.nextInt();
			
			

			String sql = "INSERT INTO student VALUES("+id+",'"+name+"',"+sub1+","+sub2+","+sub3+","+(sub1+sub2+sub3)+")";
			int n =stmt.executeUpdate(sql);
			
			if (n==1)
			{
				System.out.println("Executed successfully");
			}
			else
				System.out.println("Please enter valid entries");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}