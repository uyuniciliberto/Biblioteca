package pkgVistaTabla;

import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;
import pkgControladorSQL.clControladorAlumno;

public class clVistaTablaAlumno extends AbstractTableModel {

    private clControladorAlumno controladorAlumno = new clControladorAlumno();

    public clVistaTablaAlumno(clControladorAlumno controladorAlumno) {
        this.controladorAlumno=controladorAlumno;
    }

    @Override
    public int getRowCount() {
        
    }

    @Override
    public int getColumnCount() {
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            resultSet.absolute(rowIndex + 1);
            return resultSet.getObject(columnIndex + 1);
        } catch (SQLException ex) {
            return ex.toString();
        }

    }

    @Override
    public String getColumnName(int column) {
        
    }
}
