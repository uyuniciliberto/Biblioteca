package pkgControladorEventos;

import pkgVista.frmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkgControladorEventos.clControladorEventosAlumno;
import pkgControladorEventos.clControladorEventosLibros;
import pkgControladorEventos.clControladorEventosPrestamo;

public class clControladorEventosPrincipal implements ActionListener {
    
    private frmPrincipal frmmenu;

    public void iniciarFramePrincipal() {
        frmmenu = new frmPrincipal();
        frmmenu.setVisible(true);        
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand() == "btnAlumnos") {
            clControladorEventosAlumno controladorEventosAlumno = new clControladorEventosAlumno(false);
        }  else if (e.getActionCommand() == "btnInformes") {
            
        } else if (e.getActionCommand() == "btnPrestamos") {
            clControladorEventosPrestamo controladorEventosPrestamo = new clControladorEventosPrestamo();
        } else if (e.getActionCommand() == "btnLibros") {
            clControladorEventosLibros controladorEventosLibros = new clControladorEventosLibros();
        } else {
            System.exit(0);
        }
    }

}