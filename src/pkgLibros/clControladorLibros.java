/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgLibros;

import java.sql.ResultSet;
import java.sql.SQLException;
import pkgConexion.clConexionSingleton;

/**
 *
 * @author UyuCilDel
 */
public class clControladorLibros {
    
    private ResultSet resultadoQuery = null;

    public ResultSet getTodosLosLibros() throws SQLException {
        resultadoQuery = clConexionSingleton.getInstance().executeQuery("select * from libros");
        return resultadoQuery;
    }
    
     public void baja(clLibros libro) throws SQLException {
        clConexionSingleton.getInstance().actualizar("delete from libros where codigo = " + libro.getCodigo());
    }

    public void alta(clLibros libro) throws SQLException {
        System.out.println("insert into libros (titulo,autor,editorial,asignatura,estado) values ('"
                + libro.getTitulo()+ "','"
                + libro.getAutor()+ "','"
                + libro.getEditorial()+ "','"
                + libro.getAsignatura()+ "','"
                + libro.getEstado()+ "');");
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
    
}
