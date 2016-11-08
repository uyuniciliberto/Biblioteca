package pkgLibros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author UyuCilDel
 */
public class clControladorEventosLibros implements ActionListener, DocumentListener{
    
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
            } else if (e.getActionCommand() == "btnBuscar") {
                clLibros libro = this.crearLibro();
                dialog.actualizarPor(controladorLibros.Busqueda(libro));
            } else if (e.getActionCommand() == "btnReset") {
                dialog.actualizar();
            } else if (e.getActionCommand() == "btnSeleccionar") {
                //seleccionar desde prestamos
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
    
}