package pkgControladorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkgObjetos.clAlumno;
import pkgConexion.clConexionSingleton;

public class clControladorAlumno {
    
    private ResultSet resultadoConsulta;

    public void getTodosLosAlumnos() throws SQLException {
        resultadoConsulta = clConexionSingleton.getInstance().executeQuery("select * from alumnos");
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

    public void Busqueda(clAlumno alumno) throws SQLException{
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
        if(alumno.getRegistro()>=0){
            sql = sql + "registro=" + alumno.getRegistro() + " and ";
        }
        resultadoConsulta = clConexionSingleton.getInstance().executeQuery(sql.substring(0, sql.length()-4));
    }
    
    public clAlumno getAlumno(int row) throws SQLException{
        clAlumno alumno = new clAlumno();
        resultadoConsulta.absolute(row);
        alumno.setRegistro(resultadoConsulta.getInt(1));
        alumno.setDni(resultadoConsulta.getString(2));
        alumno.setNombre(resultadoConsulta.getString(3));
        alumno.setApellido1(resultadoConsulta.getString(4));
        alumno.setApellido2(resultadoConsulta.getString(5));
        return alumno;
    }

    public ResultSet getResultadoConsulta() {
        return resultadoConsulta;
    }
    
    public int calcularRows(){
        try {
            if (resultadoConsulta.last()){
                return resultadoConsulta.getRow();
            }
        } catch (SQLException ex) {
            Logger.getLogger(clControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}