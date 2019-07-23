package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class ConnFactory {
//Singleton Factory
    private static ConnFactory cf = new ConnFactory();
    //constructor
    private ConnFactory() {
        super();
    }
    public static synchronized ConnFactory getInstance() {
        if(cf==null) {
            cf= new ConnFactory();
        }
        return cf;
    }
    
    public static Connection getConnection(String filename) throws SQLException {
		Connection c = null;
		try {
		Properties prop = new Properties();
		InputStream in = ConnFactory.class.getClassLoader().getResourceAsStream(filename);
		prop.load(in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("password"));
		} catch(ClassNotFoundException ex) {
			System.out.println("unable to load driver class!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return c;
	}
    
    
    
    
    
   /* public Connection getConnection() {
        Connection conn = null;
        Properties prop = new Properties();
        
        try {
            prop.load(new FileReader("database.properties"));
            Class.forName(prop.getProperty("driver"));
            conn = DriverManager.getConnection(
                    prop.getProperty("url"), 
                    prop.getProperty("usr"),
                    prop.getProperty("password"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }*/
}

