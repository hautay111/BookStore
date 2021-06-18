package ui;

import javax.swing.*;
import java.sql.*;
import java.util.Properties;
 
class DataBase {
	
    private Connection getConnection() throws SQLException {
        Connection conn;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "yourPassword");
        String sql="select * from book" ;
        conn = conn = DriverManager.getConnection("jdbc:mysql://localhost/bookstore", "root", "");
        return conn;
    }
 
    ResultSet search(String searchFor, JPanel panel) {
        PreparedStatement statement;
        Connection connection = null;
        try {
        	
            connection = getConnection();
            statement = connection.prepareStatement("select id,name,author,price,amount from book where name = ? or author = ? or " +
                    "price = ?");
            statement.setString(1, searchFor);
            statement.setString(2, searchFor);
            statement.setString(3, searchFor);
            return statement.executeQuery();
 
        } catch (SQLException e) {
            if (connection == null) {
                JOptionPane.showMessageDialog(panel, "Connection to database failed.");
            } else {
                JOptionPane.showMessageDialog(panel, "No results found for" + searchFor + " in the database.");
            }
            e.printStackTrace();
        }
        return null;
    }
}