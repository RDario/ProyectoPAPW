/**
 *
 * @author Dario
 */

package clasesConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDataBase {
    private static String PASSWORD = "";
    private static String PORT = "3306";
    private static String USER = "root";
    private static String HOST = "localhost";
    private static String DATABASE = "db_papw";
    private static String CLASSNAME = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://" + HOST +":" + PORT + "/" + DATABASE;
    private static Connection _connection;
    
    public ConexionDataBase(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            _connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        return _connection;
    }

    private void setConnection(Connection _connection) {
        this._connection = _connection;
    }
}
