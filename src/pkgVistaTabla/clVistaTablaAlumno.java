package pkgVistaTabla;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import pkgControladorSQL.clControladorAlumno;

public class clVistaTablaAlumno extends AbstractTableModel {

    private clControladorAlumno controladorAlumno = new clControladorAlumno();
    private final String[] columnas=new String[]{
        "registro",
        "Dni",
        "Nombre",
        "Apellido1",
        "Apellido2"
    };

    public clVistaTablaAlumno(clControladorAlumno controladorAlumno) {
        this.controladorAlumno=controladorAlumno;
    }

    @Override
    public int getRowCount() {
        return controladorAlumno.calcularRows();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            switch(columnIndex+1){
                case 1: return controladorAlumno.getAlumno(rowIndex+1).getRegistro();
                case 2: return controladorAlumno.getAlumno(rowIndex+1).getDni();
                case 3: return controladorAlumno.getAlumno(rowIndex+1).getNombre();
                case 4: return controladorAlumno.getAlumno(rowIndex+1).getApellido1();
                case 5: return controladorAlumno.getAlumno(rowIndex+1).getApellido2();
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
