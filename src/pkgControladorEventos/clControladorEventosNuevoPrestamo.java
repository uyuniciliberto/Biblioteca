package pkgControladorEventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import pkgObjetos.clLibros;
import pkgVista.dlgNuevoPrestamo;

public class clControladorEventosNuevoPrestamo implements ActionListener {

    private dlgNuevoPrestamo dialog;
    private clLibros libro;
    private boolean nuevo;
    private clControladorEventosPrestamos controladorEventosPrestamos;
    private Date fecha = new Date();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public clControladorEventosNuevoPrestamo(Boolean nuevo, clControladorEventosPrestamos controladorEventosPrestamos) {
        dialog = new dlgNuevoPrestamo(new javax.swing.JFrame(), true, this, nuevo);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
            }
        });
        this.controladorEventosPrestamos = controladorEventosPrestamos;
        if (!nuevo) {
            libro = controladorEventosPrestamos.getLibro();
            generarLibro();
            SimpleDateFormat sdt = new SimpleDateFormat("yyyy/MM/dd");
            dialog.getTxtFechaDevolucion().setText(sdt.format(controladorEventosPrestamos.getFechaDevolucion()));
        } else {
            dialog.getTxtFechaDevolucion().setText("0000/00/00");
        }
        this.nuevo = nuevo;
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("btnAceptar")) {
            if (!isEmpty() && isFechaSelected()) {
                if (estadoChanged()) {
                    libro.setEstado(dialog.getTxtEstado().getText());
                    controladorEventosPrestamos.changeEstado(libro);
                }
                if (nuevo) {
                    controladorEventosPrestamos.nuevoPrestamo(libro, dialog.getTxtFechaDevolucion().getText());
                } else {
                    controladorEventosPrestamos.actualizarPrestamo(libro, dialog.getTxtFechaDevolucion().getText());
                }
                dialog.dispose();
            } else {
                dialog.imprimirError("No hay ningun libro seleccionado o la fecha es incorrecta formato correcto: 0000/00/00)");
            }
        } else if (e.getActionCommand().equals("btnBuscar")) {
            clControladorEventosLibros controladorEventosLibros = new clControladorEventosLibros(true);
            libro = controladorEventosLibros.getLibro();
            generarLibro();
        } else {
            dialog.dispose();
        }
    }

    public void generarLibro() {
        dialog.getTxtAsignatura().setText(libro.getAsignatura());
        dialog.getTxtAutor().setText(libro.getAutor());
        dialog.getTxtCodigo().setText("" + libro.getCodigo());
        dialog.getTxtEditorial().setText(libro.getEditorial());
        dialog.getTxtEstado().setText(libro.getEstado());
        dialog.getTxtTitulo().setText(libro.getTitulo());
    }

    public clLibros getLibro() {
        return libro;
    }

    public void setLibro(clLibros libro) {
        this.libro = libro;
    }

    public boolean isEmpty() {
        return dialog.getTxtCodigo().getText().equals("");
    }

    public boolean isFechaSelected() {
        try {
            return fecha.compareTo(new SimpleDateFormat("yyyy/MM/dd").parse(dialog.getTxtFechaDevolucion().getText())) < 0;
        } catch (ParseException e) {
            return false;
        }
    }

    public boolean estadoChanged() {
        return !(libro.getEstado().equals(dialog.getTxtEstado().getText()));
    }
}
