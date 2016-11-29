package pkgVistaTabla;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import pkgControladorSQL.clControladorPrestamos;
import pkgObjetos.clPrestamos;

public class clVistaTablaPrestamos extends AbstractTableModel{
    
    private clPrestamos prestamo;
    private int row = -1;
    private clControladorPrestamos controladorPrestamo = new clControladorPrestamos();
    private final String[] columnas = new String[]{
        "Id",
        "Codigo Alumno",
        "Codigo Libros",
        "Fecha Prestamo",
        "Fecha Devolucion",
        "Estado"
    };

    public clVistaTablaPrestamos(clControladorPrestamos controladorPrestamo) {
        this.controladorPrestamo = controladorPrestamo;
    }

    @Override
    public int getRowCount() {
        return controladorPrestamo.calcularRows();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            if(row!=rowIndex){
                prestamo = controladorPrestamo.getPrestamo(rowIndex + 1);
                row = rowIndex;
            }
            switch (columnIndex + 1) {
                case 1:
                    return prestamo.getId();
                case 2:
                    return prestamo.getCodAlumno();
                case 3:
                    return prestamo.getCodLibros();
                case 4:
                    return prestamo.getFechaPrestamo();
                case 5:
                    return prestamo.getFechaDevolucion();
                case 6:
                    return prestamo.getEstado();
            }
        } catch (SQLException ex) {
            Logger.getLogger(clVistaTablaPrestamos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
