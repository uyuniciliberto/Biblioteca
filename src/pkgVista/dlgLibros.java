package pkgVista;

import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pkgControladorEventos.clControladorEventosLibros;
import pkgControladorSQL.clControladorLibros;
import pkgVistaTabla.clVistaTablaLibros;

public class dlgLibros extends javax.swing.JDialog {

    private clVistaTablaLibros vistaTabla = null;
    private clControladorLibros controladorLibros;

    public dlgLibros(java.awt.Frame parent, boolean modal, clControladorEventosLibros controladorEventosLibros) {
        super(parent, modal);
        try {
            initComponents();
            iniciarDocumentListener(controladorEventosLibros);
            iniciarActionListener(controladorEventosLibros);
            activacionBotones();
            controladorLibros = controladorEventosLibros.getControladorLibros();
            controladorLibros.getTodosLosLibros();
            vistaTabla = new clVistaTablaLibros(controladorLibros);
            TablaLibros.setModel(vistaTabla);
        } catch (SQLException e) {
            imprimirError("Conexion.");
            btnSalir.addActionListener(controladorEventosLibros);
            btnModificaciones.setEnabled(false);
            btnSeleccionar.setEnabled(false);
            btnBuscar.setEnabled(false);
            btnBajas.setEnabled(false);
            btnAltas.setEnabled(false);
        }
    }
    
    public void iniciarDocumentListener(clControladorEventosLibros controladorEventosLibros) {
            txtAsignatura.getDocument().addDocumentListener(controladorEventosLibros);
            txtAutor.getDocument().addDocumentListener(controladorEventosLibros);
            txtCodigo.getDocument().addDocumentListener(controladorEventosLibros);
            txtEditorial.getDocument().addDocumentListener(controladorEventosLibros);
            txtEstado.getDocument().addDocumentListener(controladorEventosLibros);
            txtTitulo.getDocument().addDocumentListener(controladorEventosLibros);
    }

    public void activacionBotones() {
            btnAltas.setEnabled(false);
            btnBajas.setEnabled(false);
            btnBuscar.setEnabled(false);
            btnModificaciones.setEnabled(false);
            btnSeleccionar.setEnabled(false);
    }

    public void iniciarActionListener(clControladorEventosLibros controladorEventosLibros) {
            btnSalir.addActionListener(controladorEventosLibros);
            btnAltas.addActionListener(controladorEventosLibros);
            btnBajas.addActionListener(controladorEventosLibros);
            btnBuscar.addActionListener(controladorEventosLibros);
            btnReset.addActionListener(controladorEventosLibros);
            btnModificaciones.addActionListener(controladorEventosLibros);
            btnSeleccionar.addActionListener(controladorEventosLibros);
    }

    public void reset() {
        try {
            controladorLibros.getTodosLosLibros();
        } catch (SQLException ex) { 
            imprimirError("Conexion.");
        }
    }

    public void actualizar() {
        vistaTabla = new clVistaTablaLibros(controladorLibros);
        TablaLibros.setModel(vistaTabla);
    }

    public void imprimirError(String error) {
        JOptionPane.showMessageDialog(null, "Error en:" + error);
    }

    public JTextField getTxtAsignatura() {
        return txtAsignatura;
    }

    public void setTxtAsignatura(JTextField txtAsignatura) {
        this.txtAsignatura = txtAsignatura;
    }

    public JTextField getTxtAutor() {
        return txtAutor;
    }

    public void setTxtAutor(JTextField txtAutor) {
        this.txtAutor = txtAutor;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public JTextField getTxtEditorial() {
        return txtEditorial;
    }

    public void setTxtEditorial(JTextField txtEditorial) {
        this.txtEditorial = txtEditorial;
    }

    public JTextField getTxtEstado() {
        return txtEstado;
    }

    public void setTxtEstado(JTextField txtEstado) {
        this.txtEstado = txtEstado;
    }

    public JTextField getTxtTitulo() {
        return txtTitulo;
    }

    public void setTxtTitulo(JTextField txtTitulo) {
        this.txtTitulo = txtTitulo;
    } 

    public JButton getBtnAltas() {
        return btnAltas;
    }

    public void setBtnAltas(JButton btnAltas) {
        this.btnAltas = btnAltas;
    }

    public JButton getBtnBajas() {
        return btnBajas;
    }

    public void setBtnBajas(JButton btnBajas) {
        this.btnBajas = btnBajas;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JButton getBtnModificaciones() {
        return btnModificaciones;
    }

    public void setBtnModificaciones(JButton btnModificaciones) {
        this.btnModificaciones = btnModificaciones;
    }

    public JButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(JButton btnReset) {
        this.btnReset = btnReset;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public void setBtnSalir(JButton btnSalir) {
        this.btnSalir = btnSalir;
    }

    public JButton getBtnSeleccionar() {
        return btnSeleccionar;
    }

    public void setBtnSeleccionar(JButton btnSeleccionar) {
        this.btnSeleccionar = btnSeleccionar;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaLibros = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEditorial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAsignatura = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAltas = new javax.swing.JButton();
        btnBajas = new javax.swing.JButton();
        btnModificaciones = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();

        TablaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaLibrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaLibros);

        jLabel1.setText("Titulo");

        jLabel2.setText("Codigo");

        jLabel3.setText("Autor");

        txtAutor.setToolTipText("");

        jLabel4.setText("Editorial");

        jLabel5.setText("Asignatura");

        jLabel7.setText("Estado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(txtTitulo)
                        .addComponent(txtCodigo)
                        .addComponent(jLabel3)
                        .addComponent(txtAutor)
                        .addComponent(jLabel4)
                        .addComponent(txtEditorial)
                        .addComponent(jLabel5)
                        .addComponent(txtAsignatura, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                    .addComponent(jLabel7)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAltas.setText("Altas");
        btnAltas.setActionCommand("btnAltas");
        btnAltas.setMaximumSize(new java.awt.Dimension(90, 25));
        btnAltas.setMinimumSize(new java.awt.Dimension(90, 25));
        btnAltas.setPreferredSize(new java.awt.Dimension(99, 25));

        btnBajas.setText("Bajas");
        btnBajas.setActionCommand("btnBajas");
        btnBajas.setMinimumSize(new java.awt.Dimension(90, 25));
        btnBajas.setPreferredSize(new java.awt.Dimension(70, 25));

        btnModificaciones.setText("Modificar");
        btnModificaciones.setActionCommand("btnModificaciones");

        btnSalir.setText("Salir");
        btnSalir.setActionCommand("btnSalir");
        btnSalir.setMaximumSize(new java.awt.Dimension(90, 25));
        btnSalir.setMinimumSize(new java.awt.Dimension(90, 25));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/libros.gif"))); // NOI18N
        jLabel6.setToolTipText("");

        btnBuscar.setText("Buscar");
        btnBuscar.setActionCommand("btnBuscar");

        btnReset.setText("Reset");
        btnReset.setActionCommand("btnReset");

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setActionCommand("btnSeleccionar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnModificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAltas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBajas, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeleccionar)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBajas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAltas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificaciones)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaLibrosMouseClicked
        Mostrar_datos(TablaLibros.getSelectedRow());
    }//GEN-LAST:event_TablaLibrosMouseClicked
    private void Mostrar_datos(int fila) {

        txtTitulo.setText(String.valueOf(TablaLibros.getValueAt(fila, 0)));
        txtCodigo.setText(String.valueOf(TablaLibros.getValueAt(fila, 1)));
        txtAutor.setText(String.valueOf(TablaLibros.getValueAt(fila, 2)));
        txtEditorial.setText(String.valueOf(TablaLibros.getValueAt(fila, 3)));
        txtAsignatura.setText(String.valueOf(TablaLibros.getValueAt(fila, 4)));
        txtEstado.setText(String.valueOf(TablaLibros.getValueAt(fila, 4)));

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaLibros;
    private javax.swing.JButton btnAltas;
    private javax.swing.JButton btnBajas;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnModificaciones;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAsignatura;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}