<<<<<<< HEAD
package pkgPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkgAlumnos.clControladorEventosAlumno;
import pkgLibros.clControladorEventosLibros;
import pkgPrestamos.clControladorEventosPrestamo;

public class clControladorEventos implements ActionListener {
    
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
=======
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
>>>>>>> 6fa41302360cced7a2318134be91c6ea74d1cfe3
