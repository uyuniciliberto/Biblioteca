package pkgControladorEventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkgObjetos.clLibros;
import pkgVista.dlgNuevoPrestamo;

public class clControladorEventosNuevoPrestamo implements ActionListener {

    private dlgNuevoPrestamo dialog;
    private clLibros libro;

    public clControladorEventosNuevoPrestamo(Boolean nuevo) {
        dialog = new dlgNuevoPrestamo(new javax.swing.JFrame(), true, this, nuevo);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
            }
        });
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("btnAceptar")) {

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
}
