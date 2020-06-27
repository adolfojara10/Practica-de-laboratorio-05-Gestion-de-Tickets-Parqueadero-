/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.vista;

import ec.ups.edu.controlador.ControladorCliente;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Adolfo
 */
public class VentanaRegistarCliente extends javax.swing.JInternalFrame {

    private ControladorCliente controladorCliente;
    private List<String> operadoras;
    private Locale localizacion;
    private ResourceBundle recurso;

    /**
     * Creates new form VentanaRegistarCliente
     *
     * @param controladorCliente
     */
    public VentanaRegistarCliente(ControladorCliente controladorCliente) {
        initComponents();
        cargarDatosOperadora();
        formatearNumeroCasa();

        this.controladorCliente = controladorCliente;
    }

    public Locale getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Locale localizacion) {
        this.localizacion = localizacion;
    }

    public ResourceBundle getRecurso() {
        return recurso;
    }

    public void setRecurso(ResourceBundle recurso) {
        this.recurso = recurso;
    }

    public void cambiarIdioma(String idioma, String localizacion){
        labelNombre.setText(recurso.getString("labelNombre"));
        labelApellido.setText(recurso.getString("labelApellido"));
        labelCedula.setText(recurso.getString("labelCedula"));
        labelTipo.setText(recurso.getString("labelTipo"));
        labelNumero.setText(recurso.getString("labelNumero"));
        labelTelefonoOperadora.setText(recurso.getString("labelTelefonoOperadora"));
        labelCallePrincipal.setText(recurso.getString("labelCallePrincipal"));
        labelCalleSecundaria.setText(recurso.getString("labelCalleSecundaria"));
        btnCrear.setText(recurso.getString("btnCrear"));
        btnAtras.setText(recurso.getString("btnAtras"));
            
    }
    public void cargarDatosOperadora() {
        operadoras = new ArrayList<>();

        //operadoras.add("Seleccione");
        operadoras.add("Movistar");
        operadoras.add("Claro");
        operadoras.add("CNT");
        operadoras.add("Tuenti");
        operadoras.add("Etapa");

        cargarCBXOperadora();

    }

    public void cargarCBXOperadora() {

        DefaultComboBoxModel modelo = (DefaultComboBoxModel) cbxOperadora.getModel();
        for (String opera : operadoras) {
            modelo.addElement(opera);
        }

    }

    public void formatearNumeroCasa() {
        try {
            txtFormattedNumeroCasa.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(
                            new javax.swing.text.MaskFormatter("##-###")
                    )
            );
        } catch (java.text.ParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato del número de la casa erroneo");
            ex.printStackTrace();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelApellido = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        labelCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        cbxTipo = new javax.swing.JComboBox<>();
        labelTipo = new javax.swing.JLabel();
        labelNumero = new javax.swing.JLabel();
        txtFormattedNumero = new javax.swing.JFormattedTextField();
        labelTelefonoOperadora = new javax.swing.JLabel();
        cbxOperadora = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        labelCallePrincipal = new javax.swing.JLabel();
        labelCalleSecundaria = new javax.swing.JLabel();
        txtCallePrincipal = new javax.swing.JTextField();
        txtCalleSecundaria = new javax.swing.JTextField();
        labelDireccionNumero = new javax.swing.JLabel();
        txtFormattedNumeroCasa = new javax.swing.JFormattedTextField();
        btnCrear = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setResizable(true);
        setTitle("Registrar Cliente");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 12))); // NOI18N

        labelApellido.setText("Apellido: ");

        labelNombre.setText("Nombre: ");

        txtNombre.setToolTipText("Escribir el nombre del nuevo cliente");

        txtApellido.setToolTipText("Escribir el apellido");

        labelCedula.setText("Cédula:");

        txtCedula.setColumns(10);
        txtCedula.setToolTipText("Escribir la cédula del cliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNombre)
                    .addComponent(labelApellido)
                    .addComponent(labelCedula))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtApellido)
                    .addComponent(txtNombre)
                    .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Teléfono", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Casa", "Celular" }));
        cbxTipo.setToolTipText("Selecciones el tipo de celular  a ingresar");
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });

        labelTipo.setText("Tipo:");

        labelNumero.setText("Número:");

        labelTelefonoOperadora.setText("Operadora:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTipo)
                    .addComponent(labelNumero)
                    .addComponent(labelTelefonoOperadora))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxTipo, 0, 140, Short.MAX_VALUE)
                    .addComponent(txtFormattedNumero)
                    .addComponent(cbxOperadora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTipo)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumero)
                    .addComponent(txtFormattedNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefonoOperadora)
                    .addComponent(cbxOperadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dirección", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 12))); // NOI18N

        labelCallePrincipal.setText("Calle principal:");

        labelCalleSecundaria.setText("Calle secundaria: ");

        txtCallePrincipal.setToolTipText("Calle principal del domicilio del cliente");

        txtCalleSecundaria.setToolTipText("Escriba la calle seundaria del domicilio del cliente");

        labelDireccionNumero.setText("Número:");

        txtFormattedNumeroCasa.setToolTipText("Escriba el número de la casa");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelCallePrincipal)
                        .addGap(34, 34, 34)
                        .addComponent(txtCallePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(labelCalleSecundaria)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(labelDireccionNumero)
                                .addGap(71, 71, 71)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCalleSecundaria, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(txtFormattedNumeroCasa))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCallePrincipal)
                    .addComponent(txtCallePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCalleSecundaria)
                    .addComponent(txtCalleSecundaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDireccionNumero)
                    .addComponent(txtFormattedNumeroCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCrear.setBackground(new java.awt.Color(102, 102, 255));
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnAtras.setBackground(new java.awt.Color(255, 0, 0));
        btnAtras.setText("Atrás");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(83, 83, 83))
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(btnCrear)
                .addGap(18, 18, 18)
                .addComponent(btnAtras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnAtras))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        // TODO add your handling code here:
        try {
            String item = (String) cbxTipo.getSelectedItem();
            if (item.equals("Casa")) {
                txtFormattedNumero.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(593)#-####-###")
                        )
                );

            } else if (item.equals("Celular")) {
                txtFormattedNumero.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(593)###-###-###")
                        )
                );

            } else {
                txtFormattedNumero.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(593)###-###-###")
                        )
                );
            }
        } catch (java.text.ParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato del número del teléfono erroneo");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_cbxTipoActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = txtCedula.getText();
        String tipo = cbxTipo.getSelectedItem().toString();
        String numeroT = txtFormattedNumero.getText();
        String operadora = cbxOperadora.getSelectedItem().toString();
        String calleP = txtCallePrincipal.getText();
        String calleS = txtCalleSecundaria.getText();
        String numeroC = txtFormattedNumeroCasa.getText();

        if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty() || tipo.equals("Seleccione") || numeroT.isEmpty()
                || operadora.isEmpty() || calleP.isEmpty() || calleS.isEmpty() || numeroC.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos para crear un nuevo cliente");
        } else {
            String nombreCompleto = nombre.concat(apellido);
            boolean verdad = controladorCliente.crearCliente(cedula, nombreCompleto,
                    tipo, numeroT, operadora, calleP, calleS, numeroC);
            if (verdad) {
                JOptionPane.showMessageDialog(this, "Cliente creado con exito");
                this.hide();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "El cliente ya existe");
            }
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        this.hide();
        limpiar();
    }//GEN-LAST:event_btnAtrasActionPerformed
    
    
    
    public void limpiar(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        cbxTipo.setSelectedIndex(0);
        cbxOperadora.setSelectedIndex(0);
        txtFormattedNumero.setValue("");
        txtCallePrincipal.setText("");
        txtCalleSecundaria.setText("");
        txtFormattedNumeroCasa.setValue("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCrear;
    private javax.swing.JComboBox<String> cbxOperadora;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelCallePrincipal;
    private javax.swing.JLabel labelCalleSecundaria;
    private javax.swing.JLabel labelCedula;
    private javax.swing.JLabel labelDireccionNumero;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelTelefonoOperadora;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCallePrincipal;
    private javax.swing.JTextField txtCalleSecundaria;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JFormattedTextField txtFormattedNumero;
    private javax.swing.JFormattedTextField txtFormattedNumeroCasa;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
