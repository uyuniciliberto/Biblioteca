package pkgVistaTabla;

import javax.swing.table.AbstractTableModel;
import pkgControladorSQL.clControladorPrestamos;

public class clVistaTablaPrestamos extends AbstractTableModel{
    
    private int row = -1;
    private clPrestamos prestamo;
    private clControladorPrestamos controladorPrestamos = new clControladorPrestamos();
    private final String[] columnas=new String[]{
        "registro",
        "Dni",
        "Nombre",
        "Apellido1",
        "Apellido2"
    };

    public clVistaTablaPrestamos(clControladorPrestamos controladorPrestamos) {
        this.controladorPrestamos=controladorPrestamos;
    }

    @Override
    public int getRowCount() {
        return controladorPrestamos.calcularRows();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            if(row!=rowIndex){
                prestamo = controladorPrestamos.getPrestamo(rowIndex + 1);
                row = rowIndex;
            }
            switch(columnIndex+1){
                case 1: return prestamo.getId();
                case 2: return prestamo.getCodAlumno();
                case 3: return prestamo.getCodLibros();
                case 4: return prestamo.getFechaPrestamo();
                case 5: return prestamo.getFechaDevolucion();
                case 6: return prestamo.getEstado();
            }
        } catch (SQLException ex) {
            Logger.getLogger(clVistaTablaAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
