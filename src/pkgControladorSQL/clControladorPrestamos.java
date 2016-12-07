package pkgControladorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkgConexion.clConexionSingleton;
import pkgObjetos.clPrestamos;


public class clControladorPrestamos {
    
    private ResultSet resultadoQuery = null;
    
    public void getTodosLosPrestamos() throws SQLException{
        resultadoQuery = clConexionSingleton.getInstance().executeQuery("select * from prestamos");
    }
    
    public clPrestamos getPrestamo(int row) throws SQLException{
        clPrestamos prestamo = new clPrestamos();
        resultadoQuery.absolute(row);
        prestamo.setId(resultadoQuery.getInt(1));
        prestamo.setCodAlumno(resultadoQuery.getString(2));
        prestamo.setCodLibros(resultadoQuery.getString(3));
        prestamo.setFechaPrestamo(resultadoQuery.getDate(4));
        prestamo.setFechaDevolucion(resultadoQuery.getDate(5));
        prestamo.setEstado(resultadoQuery.getString(6));
        return prestamo;
    }
    
    public ResultSet getResultadoConsulta(){
        return resultadoQuery;
    }
    
    public int calcularRows(){
        try {
            if(resultadoQuery.last()){
                return resultadoQuery.getRow();
            }
        } catch (SQLException ex) {
            Logger.getLogger(clControladorPrestamos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public void setResultSet(int registro) throws SQLException{
        resultadoQuery = clConexionSingleton.getInstance().executeQuery("select * from prestamos where codAlumno = '"+registro+"'");
    }
}
