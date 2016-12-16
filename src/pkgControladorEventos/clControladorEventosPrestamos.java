package pkgControladorEventos;

import pkgVista.dlgPrestamos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkgControladorSQL.clControladorPrestamos;
import pkgObjetos.clAlumno;
import pkgObjetos.clLibros;

public class clControladorEventosPrestamos extends MouseAdapter implements ActionListener {

    private dlgPrestamos dialog;
    private int row;
    private clAlumno alumno;
    private clControladorPrestamos controladorPrestamos = new clControladorPrestamos();
    private clLibros libro;

    public clControladorEventosPrestamos() {
        dialog = new dlgPrestamos(new javax.swing.JFrame(), true, this);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
            }
        });
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand().equals("btnBuscar")) {
                clControladorEventosAlumno controladorEventosAlumno = new clControladorEventosAlumno(true);
                if (!(controladorEventosAlumno.getAlumno() == null)) {
                    alumno = controladorEventosAlumno.getAlumno();
                    controladorPrestamos.setResultSet(alumno.getRegistro());
                    generarAlumno();
                    dialog.actualizar();
                }
            } else if (e.getActionCommand().equals("btnBorrar")) {
                if (isPrestamoSelected()) {
                    controladorPrestamos.baja(getIdPrestamo());
                    controladorPrestamos.setResultSet(alumno.getRegistro());
                    dialog.actualizar();
                } else {
                    dialog.imprimirError("Es necesario seleccionar un prestamo");
                }
            } else if (e.getActionCommand().equals("btnEditar")) {
                if (isPrestamoSelected()) {
                    libro = controladorPrestamos.getLibroPrestamo(getCodLibro());
                    clControladorEventosNuevoPrestamo controladorEventosNuevoPrestamo = new clControladorEventosNuevoPrestamo(false, this);
                } else {
                    dialog.imprimirError("Es necesario seleccionar un prestamo");
                }
            } else if (e.getActionCommand().equals("btnNuevo")) {
                if (!isEmpty()) {
                    clControladorEventosNuevoPrestamo controladorEventosNuevoPrestamo = new clControladorEventosNuevoPrestamo(true, this);
                } else {
                    dialog.imprimirError("Es necesario seleccionar un alumno");
                }
            } else {
                dialog.dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(clControladorEventosPrestamos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void generarAlumno() {
        dialog.getTxtApellido1().setText(alumno.getApellido1());
        dialog.getTxtApellido2().setText(alumno.getApellido2());
        dialog.getTxtDni().setText(alumno.getDni());
        dialog.getTxtNombre().setText(alumno.getNombre());
        dialog.getTxtRegistro().setText("" + alumno.getRegistro());
    }

    public clControladorPrestamos getControladorPrestamos() {
        return controladorPrestamos;
    }

    public void nuevoPrestamo(clLibros libro, String fecha) {
        try {
            controladorPrestamos.alta(dialog.getTxtRegistro().getText(), libro, fecha);
            controladorPrestamos.setResultSet(alumno.getRegistro());
            dialog.actualizar();
        } catch (SQLException ex) {
            Logger.getLogger(clControladorEventosPrestamos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarPrestamo(clLibros libro, String fecha) {
        try {
            controladorPrestamos.update(getIdPrestamo(), libro, fecha);
            controladorPrestamos.setResultSet(alumno.getRegistro());
            dialog.actualizar();
        } catch (SQLException ex) {
            Logger.getLogger(clControladorEventosPrestamos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getCodLibro() {
        return Integer.parseInt((String) dialog.getTablaLibros().getValueAt(dialog.getRow(), 2));
    }

    public int getIdPrestamo() {
        return (int) dialog.getTablaLibros().getValueAt(dialog.getRow(), 0);
    }

    public Date getFechaDevolucion() {
        return (Date) dialog.getTablaLibros().getValueAt(dialog.getRow(), 4);
    }

    public clLibros getLibro() {
        return libro;
    }

    public void setLibro(clLibros libro) {
        this.libro = libro;
    }

    public boolean isEmpty() {
        return dialog.getTxtRegistro().getText().equals("");
    }

    public boolean isPrestamoSelected() {
        return dialog.getTablaLibros().isRowSelected(dialog.getRow());
    }
    
    public void changeEstado(clLibros libro){
        try {
            controladorPrestamos.changeEstado(libro);
        } catch (SQLException ex) {
            Logger.getLogger(clControladorEventosPrestamos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
