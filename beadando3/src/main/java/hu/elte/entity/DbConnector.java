/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.entity;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simone Gulyas
 */
public class DbConnector {
    final private String USER ="root";
    final private String PASSWORD ="1234";
    final private String DATABASE ="com.mysql.jdbc.Driver";
    final private String SERVERNAME = "localhost";
    final private int PORT = 3306;
    final private String DATABASE_NAME = "snake";
    private static MysqlConnectionPoolDataSource conn = null;

    public DbConnector() {
        
        try {
            if(conn == null){
                Class.forName(DATABASE);
                conn = new MysqlConnectionPoolDataSource();
                conn.setServerName(SERVERNAME);
                conn.setPort(PORT);
                conn.setDatabaseName(DATABASE_NAME);
                conn.setUser(USER);
                conn.setPassword(PASSWORD);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void setConn(MysqlConnectionPoolDataSource conn) {
        DbConnector.conn = conn;
    }
    
    
}
