package pkgAlumnos;

import java.sql.ResultSet;
import java.sql.SQLException;
import pkgConexion.clConexionSingleton;

public class clControladorAlumno {

    public ResultSet getTodosLosAlumnos() throws SQLException {
        return clConexionSingleton.getInstance().executeQuery("select * from alumnos");
    }

    public void baja(clAlumno alumno) throws SQLException {
        clConexionSingleton.getInstance().actualizar("delete from alumnos where registro = " + alumno.getRegistro());

    }

    public void alta(clAlumno alumno) throws SQLException {
        clConexionSingleton.getInstance().actualizar("insert into alumnos (dni,nombre,apellido1,apellido2) values ('"
                + alumno.getDni() + "','"
                + alumno.getNombre() + "','"
                + alumno.getApellido1() + "','"
                + alumno.getApellido2() + "');");
    }

    public void modificaciones(clAlumno alumno) throws SQLException {
        clConexionSingleton.getInstance().actualizar("update alumnos set "
                + "dni = '" + alumno.getDni() + "', "
                + "nombre = '" + alumno.getNombre() + "', "
                + "apellido1 = '" + alumno.getApellido1() + "', "
                + "apellido2 = '" + alumno.getApellido2() + "' "
                + "where registro = " + alumno.getRegistro() + ";");
    }

    public ResultSet Busqueda(clAlumno alumno) throws SQLException{
        String sql = "select * from alumnos where ";
        if (!alumno.getApellido1().equals("")) {
            sql = sql + "apellido1='" + alumno.getApellido1() + "' and ";
        }
        if(!alumno.getApellido2().equals("")){
            sql = sql + "apellido2='" + alumno.getApellido2() + "' and ";
        }
        if(!alumno.getDni().equals("")){
            sql = sql + "dni='" + alumno.getDni() + "' and ";
        }
        if(!alumno.getNombre().equals("")){
            sql = sql + "nombre='" + alumno.getNombre() + "' and ";
        }
        if(!alumno.getRegistro().equals("")){
            sql = sql + "registro=" + alumno.getRegistro() + " and ";
        }
        System.out.println(sql.substring(0, sql.length()-4));
        return clConexionSingleton.getInstance().executeQuery(sql.substring(0, sql.length()-4));
    }

}