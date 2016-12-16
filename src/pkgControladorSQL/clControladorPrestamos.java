package pkgControladorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkgConexion.clConexionSingleton;
import pkgObjetos.clLibros;
import pkgObjetos.clPrestamos;

public class clControladorPrestamos {

    private ResultSet resultadoQuery = null;

    public void getTodosLosPrestamos() throws SQLException {
        resultadoQuery = clConexionSingleton.getInstance().executeQuery("select * from prestamos");
    }

    public clPrestamos getPrestamo(int row) throws SQLException {
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

    public ResultSet getResultadoConsulta() {
        return resultadoQuery;
    }

    public int calcularRows() {
        try {
            if (resultadoQuery.last()) {
                return resultadoQuery.getRow();
            }
        } catch (SQLException ex) {
            Logger.getLogger(clControladorPrestamos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void setResultSet(int registro) throws SQLException {
        resultadoQuery = clConexionSingleton.getInstance().executeQuery("select * from prestamos where codAlumno = '" + registro + "'");
    }

    public clLibros getLibroPrestamo(int codLibro) throws SQLException {
        ResultSet resultadoQueryLibro = clConexionSingleton.getInstance().executeQuery("select * from libros where codigo = " + codLibro);
        clLibros libro = new clLibros();
        resultadoQueryLibro.next();
        libro.setCodigo(resultadoQueryLibro.getInt(1));
        libro.setTitulo(resultadoQueryLibro.getString(2));
        libro.setAutor(resultadoQueryLibro.getString(3));
        libro.setEditorial(resultadoQueryLibro.getString(4));
        libro.setAsignatura(resultadoQueryLibro.getString(5));
        libro.setEstado(resultadoQueryLibro.getString(6));
        return libro;
    }

    public void alta(String registro, clLibros libro, String fecha) throws SQLException {
        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd");
        clConexionSingleton.getInstance().actualizar("insert into prestamos (codAlumno,codLibros,FechaPrestamo,FechaDevolucion,estado) values("
                + registro + ","
                + libro.getCodigo() + ",'"
                + sdf.format(fechaActual) + "','"
                + fecha + "','"
                + libro.getEstado() + "')");
    }

    public void baja(int id) throws SQLException {
        clConexionSingleton.getInstance().actualizar("delete from prestamos where id=" + id);
    }

    public void update(int id, clLibros libro, String fecha) throws SQLException {
        clConexionSingleton.getInstance().actualizar("update prestamos set estado = '" + libro.getEstado() + "',"
                + "FechaDevolucion = '" + fecha + "'"
                + "where id=" + id);
    }

    public void changeEstado(clLibros libro) throws SQLException {
        System.out.println("estado del libro "+libro.getCodigo()+"cambiado a "+libro.getEstado());
        System.out.println("update libros set estado = '" + libro.getEstado()
                + "' where codigo=" + libro.getCodigo());
        clConexionSingleton.getInstance().actualizar("update libros set estado = '" + libro.getEstado()
                + "' where codigo=" + libro.getCodigo());
    }
}
