package pkgVistaTabla;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class clVistaTablaAlumno extends AbstractTableModel {

    ResultSet resultSet;
    ResultSetMetaData resultSetMetaData;
    int numeroColumnas;
    int numeroFilas;

    public clVistaTablaAlumno(clAlumno alumno) {
        
    }

    @Override
    public int getRowCount() {
        return numeroFilas;

    }

    @Override
    public int getColumnCount() {
        return numeroColumnas;
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
        try {
            return resultSetMetaData.getColumnName(column+1);
        } catch (SQLException ex) {
            return ex.toString();
        }
    }
}
