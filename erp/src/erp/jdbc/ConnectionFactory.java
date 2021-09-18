/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Renato
 */
public class ConnectionFactory {
    
    public Statement stm ;
    public ResultSet rs ;
    public Connection conn;
    
    public void executaSQL(String sql) throws SQLException{
        try{
            conn = ConnectionFactory.getConnection();
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO : " +e );
            
        }
    }
    
    
    
    
    
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/vendas?user=root&password=12345&serverTimezone=UTC & characterEncoding = UTF-8 & useUnicode = yes" );
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
}
}
