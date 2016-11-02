package pkgConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class clConexionSingleton {

    private Connection connect = null;
    private ResultSet resultQuery = null;
    private static clConexionSingleton instance = null;

    protected clConexionSingleton() throws SQLException {
        String sUrl = "jdbc:mysql://localhost:3306/Biblioteca";
        connect = DriverManager.getConnection(sUrl, "root", "");
    }
    
    public static clConexionSingleton getInstance() throws SQLException{
        if(instance == null){
            instance = new clConexionSingleton();
        }
        return instance;
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        Statement stmt = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultQuery = stmt.executeQuery(sql);
        return resultQuery;
    }

    public void actualizar(String sql) throws SQLException {
        Statement stmt = connect.createStatement();
        stmt.executeUpdate(sql);
    }

}
