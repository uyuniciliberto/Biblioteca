package pkgPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkgAlumnos.clControladorEventosAlumno;
import pkgLibros.clControladorEventosLibros;

public class clControladorEventos implements ActionListener {
    
    private frmPrincipal frmmenu;

    public void iniciarFramePrincipal() {
        frmmenu = new frmPrincipal();
        frmmenu.setVisible(true);        
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand() == "btnAlumnos") {
            clControladorEventosAlumno controladorEventosAlumno = new clControladorEventosAlumno(frmmenu);
        }  else if (e.getActionCommand() == "btnInformes") {
            
        } else if (e.getActionCommand() == "btnPrestamos") {

        } else if (e.getActionCommand() == "btnLibros") {
            clControladorEventosLibros controladorEventosLibros = new clControladorEventosLibros();
        } else {
            System.exit(0);
        }
    }

}
