package pkgPrincipal;

import javax.swing.JOptionPane;
import pkgAlumnos.dlgAlumnos;

public class Main {

    public static void main(String[] args) {
        clControladorEventos controladorEventos = new clControladorEventos();
        controladorEventos.iniciarFramePrincipal();
        System.out.println("funciona?");
    }

}
