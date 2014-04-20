/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.training.jdbc.train;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rain
 */
public class DAO {

    public List<String[]> getData() {
        Connection connection = null;
        List<String[]> result = new ArrayList();
        try {
            String driver = "jdbc:oracle:thin:@localhost:1521:testdb";
            String username = "admin";
            String password = "1234";
            
            connection = DriverManager.getConnection(driver,username,password);

            String query = "SELECT * FROM DRUG";

            Statement createStatement = connection.createStatement();

            ResultSet resultSet = createStatement.executeQuery(query);

            while (resultSet.next()) {
                String[] arr = new String[2];
                arr[0] = resultSet.getString("DRUGID");
                arr[1] = resultSet.getString("DRUGNAME");
                result.add(arr);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return result;
    }
}
