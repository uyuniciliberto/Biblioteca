/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgLibros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author UyuCilDel
 */
public class clControladorEventosLibros implements ActionListener{
    
    private dlgLibros dialog;
    private clLibros libro;

    public clControladorEventosLibros() {
        dialog = new dlgLibros(new javax.swing.JFrame(), true, this);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
            }
        });
        dialog.setVisible(true);
    } 
    
    public clLibros crearLibro(){
        libro = new clLibros();
        libro.setAsignatura(dialog.getTxtAsignatura().getText());
        libro.setAutor(dialog.getTxtAutor().getText());
        libro.setCodigo(dialog.getTxtCodigo().getText());
        libro.setEditorial(dialog.getTxtEditorial().getText());
        libro.setEstado(dialog.getTxtEstado().getText());
        libro.setTitulo(dialog.getTxtTitulo().getText());
        return libro;                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            clControladorLibros controladorLibros = new clControladorLibros();
            if (e.getActionCommand() == "btnAltas") {
                controladorLibros.alta(crearLibro());
                dialog.actualizar();
            } else if (e.getActionCommand() == "btnBajas") {
                controladorLibros.baja(crearLibro());
                dialog.actualizar();
            } else if (e.getActionCommand() == "btnModificaciones") {
                controladorLibros.modificaciones(crearLibro());
                dialog.actualizar();
            } else {
                dialog.dispose();
            }
        } catch (SQLException sQLException) {
            dialog.imprimirError("Consulta.");
        }
    }
    
}
