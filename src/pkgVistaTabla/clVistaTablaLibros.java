package pkgVistaTabla;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import pkgControladorSQL.clControladorLibros;

public class clVistaTablaLibros extends AbstractTableModel {
    
    private clControladorLibros controladorLibros = new clControladorLibros();
    private final String[] columnas=new String[]{
        "Titulo",
        "Codigo",
        "Autor",
        "Editorial",
        "Asignatura",
        "Estado"
    };

    public clVistaTablaLibros(clControladorLibros controladorLibros) {
        this.controladorLibros=controladorLibros;
    }

    @Override
    public int getRowCount() {
        return controladorLibros.calcularRows();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            switch(columnIndex+1){
                case 1: return controladorLibros.getLibro(rowIndex+1).getTitulo();
                case 2: return controladorLibros.getLibro(rowIndex+1).getCodigo();
                case 3: return controladorLibros.getLibro(rowIndex+1).getAutor();
                case 4: return controladorLibros.getLibro(rowIndex+1).getEditorial();
                case 5: return controladorLibros.getLibro(rowIndex+1).getAsignatura();
                case 6: return controladorLibros.getLibro(rowIndex+1).getEstado();
            }
        } catch (SQLException ex) {
            Logger.getLogger(clVistaTablaLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}

