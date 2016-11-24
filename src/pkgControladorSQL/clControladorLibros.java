package pkgControladorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkgConexion.clConexionSingleton;
import pkgObjetos.clLibros;

public class clControladorLibros {
    
    private ResultSet resultadoQuery = null;

    public void getTodosLosLibros() throws SQLException {
        resultadoQuery = clConexionSingleton.getInstance().executeQuery("select * from libros");
    }
    
     public void baja(clLibros libro) throws SQLException {
        clConexionSingleton.getInstance().actualizar("delete from libros where codigo = " + libro.getCodigo());
    }

    public void alta(clLibros libro) throws SQLException {
        clConexionSingleton.getInstance().actualizar("insert into libros (titulo,autor,editorial,asignatura,estado) values ('"
                + libro.getTitulo()+ "','"
                + libro.getAutor()+ "','"
                + libro.getEditorial()+ "','"
                + libro.getAsignatura()+ "','"
                + libro.getEstado()+ "');");
    }

    public void modificaciones(clLibros libro) throws SQLException {
        clConexionSingleton.getInstance().actualizar("update libros set "
                + "titulo = '" + libro.getTitulo()+ "', "
                + "autor = '" + libro.getAutor()+ "', "
                + "editorial = '" + libro.getEditorial()+ "', "
                + "asignatura = '" + libro.getAsignatura()+ "', "
                + "estado = '" + libro.getEstado()+ "' "
                + "where codigo = " + libro.getCodigo()+";");
    }
    
    public void Busqueda(clLibros libro) throws SQLException{
        String sql = "select * from libros where ";
        if (!libro.getAsignatura().equals("")) {
            sql = sql + "asignatura='" + libro.getAsignatura()+ "' and ";
        }
        if(!libro.getAutor().equals("")){
            sql = sql + "autor='" + libro.getAutor()+ "' and ";
        }
        if(libro.getCodigo()>=0){
            sql = sql + "codigo='" + libro.getCodigo()+ "' and ";
        }
        if(!libro.getEditorial().equals("")){
            sql = sql + "editorial='" + libro.getEditorial()+ "' and ";
        }
        if(!libro.getEstado().equals("")){
            sql = sql + "estado='" + libro.getEstado() + "' and ";
        }
        if(!libro.getTitulo().equals("")){
            sql = sql + "titulo='" + libro.getTitulo()+ "' and ";
        }
        resultadoQuery = clConexionSingleton.getInstance().executeQuery(sql.substring(0, sql.length()-4));
    }
    
    public clLibros getLibro(int row) throws SQLException{
        clLibros libro = new clLibros();
        resultadoQuery.absolute(row);
        libro.setCodigo(resultadoQuery.getInt(1));
        libro.setTitulo(resultadoQuery.getString(2));
        libro.setAutor(resultadoQuery.getString(3));
        libro.setEditorial(resultadoQuery.getString(4));
        libro.setAsignatura(resultadoQuery.getString(5));
        libro.setEstado(resultadoQuery.getString(6));
        return libro;
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
            Logger.getLogger(clControladorLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}