package pkgPrincipal;

import pkgControladorEventos.clControladorEventosPrincipal;
import javax.swing.JOptionPane;
import pkgVista.dlgAlumnos;

public class Main {

    public static void main(String[] args) {
        clControladorEventosPrincipal controladorEventos = new clControladorEventosPrincipal();
        controladorEventos.iniciarFramePrincipal();
    }

}
