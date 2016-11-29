package pkgControladorEventos;

import pkgVista.dlgPrestamos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkgControladorSQL.clControladorPrestamos;
import pkgObjetos.clAlumno;


public class clControladorEventosPrestamos implements ActionListener{
    
    private dlgPrestamos dialog;
    private clAlumno alumno;
    private clControladorPrestamos controladorPrestamos = new clControladorPrestamos();
    
    public clControladorEventosPrestamos(){
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
        if(e.getActionCommand().equals("btnBuscar")){
            clControladorEventosAlumno controladorEventosAlumno = new clControladorEventosAlumno(true);
            alumno=controladorEventosAlumno.getAlumno();
            generarAlumno();
        }
    }
    
    public void generarAlumno(){
        dialog.getTxtApellido1().setText(alumno.getApellido1());
        dialog.getTxtApellido2().setText(alumno.getApellido2());
        dialog.getTxtDni().setText(alumno.getDni());
        dialog.getTxtNombre().setText(alumno.getNombre());
        dialog.getTxtRegistro().setText(""+alumno.getRegistro());
    }

    public clControladorPrestamos getControladorPrestamos() {
        return controladorPrestamos;
    }
}
