package pkgVistaTabla;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class clVistaTabla extends AbstractTableModel {

    ResultSet resultSet;
    ResultSetMetaData resultSetMetaData;
    int numeroColumnas;
    int numeroFilas;

    public clVistaTabla(ResultSet rs) {
        this.resultSet = rs;
        try {
            resultSetMetaData = rs.getMetaData();
            resultSet.last();
            numeroFilas = resultSet.getRow();
            numeroColumnas = resultSetMetaData.getColumnCount();
        } catch (SQLException ex) {
        }
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

}

