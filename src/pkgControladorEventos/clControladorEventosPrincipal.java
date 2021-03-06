package pkgControladorEventos;

import pkgVista.frmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkgInformes.clControladorInformes;

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
            clControladorInformes controladorInformes = new clControladorInformes();
            controladorInformes.crearInformeAlumnos();
        } else if (e.getActionCommand() == "btnPrestamos") {
            clControladorEventosPrestamos controladorEventosPrestamo = new clControladorEventosPrestamos();
        } else if (e.getActionCommand() == "btnLibros") {
            clControladorEventosLibros controladorEventosLibros = new clControladorEventosLibros(false);
        } else {
            System.exit(0);
        }
    }

}