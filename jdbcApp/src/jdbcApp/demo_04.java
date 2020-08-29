package jdbcApp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

// Storing the regular JDBC Credentials into prop file, to reuse
// Reuse these credentials in all other JDBC Client applications

public class demo_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Properties properties = new Properties();
		properties.setProperty("dri", "com.mysql.jdbc.Driver");
		properties.setProperty("url", "jdbc:mysql://localhost:3306/students");
		properties.setProperty("un", "root");
		properties.setProperty("pw", "root");
		
		try {
			properties.store(new FileOutputStream("db.prop"), "Regular properties to run JDBC Applications");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
