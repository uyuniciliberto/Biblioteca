package pkgControladorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import pkgConexion.clConexionSingleton;


public class clControladorPrestamos {
    
    private ResultSet resultadoQuery = null;
    
    public ResultSet getTodosLosPrestamos() throws SQLException{
        resultadoQuery = clConexionSingleton.getInstance().executeQuery("select * from prestamos");
        return resultadoQuery;
    }
}
