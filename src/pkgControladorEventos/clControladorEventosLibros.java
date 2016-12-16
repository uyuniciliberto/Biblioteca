package pkgControladorEventos;

import pkgVista.dlgLibros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import pkgControladorSQL.clControladorLibros;
import pkgObjetos.clLibros;

public class clControladorEventosLibros implements ActionListener, DocumentListener{
    
    private dlgLibros dialog;
    private clLibros libro;
    private clControladorLibros controladorLibros = new clControladorLibros();

    public clControladorEventosLibros(boolean seleccionar) {
        dialog = new dlgLibros(new javax.swing.JFrame(), true, this);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
            }
        });
        dialog.getBtnSeleccionar().setEnabled(seleccionar);
        dialog.setVisible(true);
    } 
    
    public clLibros crearLibro(){
        libro = new clLibros();
        if(!dialog.getTxtCodigo().getText().equals("")){
            libro.setCodigo(Integer.parseInt(dialog.getTxtCodigo().getText()));
        }else{
            libro.setCodigo(-1);
        } 
        libro.setAsignatura(dialog.getTxtAsignatura().getText());
        libro.setAutor(dialog.getTxtAutor().getText());
        libro.setEditorial(dialog.getTxtEditorial().getText());
        libro.setEstado(dialog.getTxtEstado().getText());
        libro.setTitulo(dialog.getTxtTitulo().getText());
        return libro;                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand() == "btnAltas") {
                controladorLibros.alta(crearLibro());
                dialog.reset();
                dialog.actualizar();
            } else if (e.getActionCommand() == "btnBajas") {
                controladorLibros.baja(crearLibro());
                dialog.reset();
                dialog.actualizar();
            } else if (e.getActionCommand() == "btnModificaciones") {
                controladorLibros.modificaciones(crearLibro());
                dialog.reset();
                dialog.actualizar();
            } else if (e.getActionCommand() == "btnBuscar") {
                controladorLibros.Busqueda(crearLibro());
                dialog.actualizar();
            } else if (e.getActionCommand() == "btnReset") {
                resetTextFields();
                dialog.reset();
                dialog.actualizar();
            } else if (e.getActionCommand() == "btnSeleccionar") {
                crearLibro();
                dialog.dispose();
            } else {
                dialog.dispose();
            }
        } catch (SQLException sQLException) {
            dialog.imprimirError("Consulta.");
        }
    }
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        actualizarBotones();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        actualizarBotones();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        System.out.println("AAAH! Asi que el changedUpdate hacia esto, interesante cuanto menos.");
    }

    private void actualizarBotones() {
        dialog.getBtnAltas().setEnabled(
                (!dialog.getTxtAsignatura().getText().equals("")
                || !dialog.getTxtAutor().getText().equals("")
                || !dialog.getTxtEditorial().getText().equals("")
                || !dialog.getTxtEstado().getText().equals("")
                || !dialog.getTxtTitulo().getText().equals(""))
                && dialog.getTxtCodigo().getText().equals(""));
        dialog.getBtnBajas().setEnabled(
                (!dialog.getTxtAsignatura().getText().equals("")
                || !dialog.getTxtAutor().getText().equals("")
                || !dialog.getTxtEditorial().getText().equals("")
                || !dialog.getTxtEstado().getText().equals("")
                || !dialog.getTxtTitulo().getText().equals(""))
                && !dialog.getTxtCodigo().getText().equals(""));
        dialog.getBtnModificaciones().setEnabled(
                (!dialog.getTxtAsignatura().getText().equals("")
                || !dialog.getTxtAutor().getText().equals("")
                || !dialog.getTxtEditorial().getText().equals("")
                || !dialog.getTxtEstado().getText().equals("")
                || !dialog.getTxtTitulo().getText().equals(""))
                && !dialog.getTxtCodigo().getText().equals(""));
        dialog.getBtnBuscar().setEnabled(
                !dialog.getTxtAsignatura().getText().equals("")
                || !dialog.getTxtAutor().getText().equals("")
                || !dialog.getTxtEditorial().getText().equals("")
                || !dialog.getTxtEstado().getText().equals("")
                || !dialog.getTxtTitulo().getText().equals("")
                || !dialog.getTxtCodigo().getText().equals(""));
    }
    
    public clLibros getLibro(){
        return libro;
    }
    
    public clControladorLibros getControladorLibros(){
        return controladorLibros;
    }
    
    public void resetTextFields(){
        dialog.getTxtAsignatura().setText("");
        dialog.getTxtAutor().setText("");
        dialog.getTxtCodigo().setText("");
        dialog.getTxtEditorial().setText("");
        dialog.getTxtEstado().setText("");
        dialog.getTxtTitulo().setText("");
    }
}