package pkgVistaTabla;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import pkgControladorSQL.clControladorLibros;
import pkgObjetos.clLibros;

public class clVistaTablaLibros extends AbstractTableModel {
    
    private int row=-1;
    private clLibros libro;
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
            if(row!=rowIndex){
                libro = controladorLibros.getLibro(rowIndex + 1);
                row = rowIndex;
            }
            switch(columnIndex+1){
                case 1: return libro.getTitulo();
                case 2: return libro.getCodigo();
                case 3: return libro.getAutor();
                case 4: return libro.getEditorial();
                case 5: return libro.getAsignatura();
                case 6: return libro.getEstado();
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