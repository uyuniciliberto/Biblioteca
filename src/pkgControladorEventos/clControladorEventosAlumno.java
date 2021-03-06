package pkgControladorEventos;

import pkgVista.dlgAlumnos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import pkgObjetos.clAlumno;
import pkgControladorSQL.clControladorAlumno;

public class clControladorEventosAlumno implements ActionListener, DocumentListener {

    private dlgAlumnos dialog;
    private clAlumno alumno;
    private clControladorAlumno controladorAlumno = new clControladorAlumno();

    public clControladorEventosAlumno(boolean seleccionar) {
        dialog = new dlgAlumnos(new javax.swing.JFrame(), true, this);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
            }
        });
        dialog.getBtnSeleccionar().setEnabled(seleccionar);
        dialog.setVisible(true);
    }

    public clAlumno crearAlumno() {
        alumno = new clAlumno();
        if(!dialog.getTxtRegistro().getText().equals("")){
            alumno.setRegistro(Integer.parseInt(dialog.getTxtRegistro().getText()));
        }else{
            alumno.setRegistro(-1);
        }    
        alumno.setNombre(dialog.getTxtNombre().getText());//miau!
        alumno.setDni(dialog.getTxtDni().getText());
        alumno.setApellido1(dialog.getTxtApellido1().getText());
        alumno.setApellido2(dialog.getTxtApellido2().getText());
        return alumno;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand() == "btnAltas") {
                controladorAlumno.alta(crearAlumno());
                dialog.reset();
                dialog.actualizar();
            } else if (e.getActionCommand() == "btnBajas") {
                controladorAlumno.baja(crearAlumno());
                dialog.reset();
                dialog.actualizar();
            } else if (e.getActionCommand() == "btnModificaciones") {
                controladorAlumno.modificaciones(crearAlumno());
                dialog.reset();
                dialog.actualizar();
            } else if (e.getActionCommand() == "btnBuscar") {
                controladorAlumno.Busqueda(crearAlumno());
                dialog.actualizar();
            } else if (e.getActionCommand() == "btnReset") {
                resetTextFields();
                dialog.reset();
                dialog.actualizar();
            } else if (e.getActionCommand() == "btnSeleccionar") {
                crearAlumno();
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
                (!dialog.getTxtDni().getText().equals("")
                || !dialog.getTxtNombre().getText().equals("")
                || !dialog.getTxtApellido1().getText().equals("")
                || !dialog.getTxtApellido2().getText().equals(""))
                && dialog.getTxtRegistro().getText().equals(""));
        dialog.getBtnBajas().setEnabled(
                (!dialog.getTxtDni().getText().equals("")
                || !dialog.getTxtNombre().getText().equals("")
                || !dialog.getTxtApellido1().getText().equals("")
                || !dialog.getTxtApellido2().getText().equals(""))
                && !dialog.getTxtRegistro().getText().equals(""));
        dialog.getBtnModificaciones().setEnabled(
                (!dialog.getTxtDni().getText().equals("")
                || !dialog.getTxtNombre().getText().equals("")
                || !dialog.getTxtApellido1().getText().equals("")
                || !dialog.getTxtApellido2().getText().equals(""))
                && !dialog.getTxtRegistro().getText().equals(""));
        dialog.getBtnBuscar().setEnabled(
                !dialog.getTxtDni().getText().equals("")
                || !dialog.getTxtNombre().getText().equals("")
                || !dialog.getTxtApellido1().getText().equals("")
                || !dialog.getTxtApellido2().getText().equals("")
                || !dialog.getTxtRegistro().getText().equals(""));
    }

    public clAlumno getAlumno() {
        return alumno;
    }

    public clControladorAlumno getControladorAlumno() {
        return controladorAlumno;
    }
    
    public void resetTextFields(){
        dialog.getTxtApellido1().setText("");
        dialog.getTxtApellido2().setText("");
        dialog.getTxtDni().setText("");
        dialog.getTxtNombre().setText("");
        dialog.getTxtRegistro().setText("");
    }
}
