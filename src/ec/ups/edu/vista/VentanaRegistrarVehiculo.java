/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.vista;

import ec.ups.edu.controlador.ControladorCliente;
import ec.ups.edu.controlador.ControladorVehiculo;
import ec.ups.edu.modelo.Cliente;
import ec.ups.edu.modelo.Vehiculo;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.*;

/**
 *
 * @author Adolfo
 */
public class VentanaRegistrarVehiculo extends javax.swing.JInternalFrame {

    private ControladorCliente controladorCliente;
    private ControladorVehiculo controladorVehiculo;
    private VentanaRegistarCliente ventanaRegistarCliente;

    private Locale localizacion;
    private ResourceBundle recurso;

    /**
     * Creates new form VentanaRegistrarVehiculo
     */
    public VentanaRegistrarVehiculo(ControladorCliente controladorCliente, ControladorVehiculo controladorVehiculo,
            VentanaRegistarCliente ventanaRegistarCliente) {
        initComponents();

        this.controladorCliente = controladorCliente;
        this.controladorVehiculo = controladorVehiculo;

        this.ventanaRegistarCliente = ventanaRegistarCliente;
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

    public void cambiarIdioma(String idioma, String localizacion) {
        this.setTitle(recurso.getString("ventanaRegistrarVehiculo"));
        labelDatosVehiculo.setText(recurso.getString("panelVehiculo"));
        labelCliente.setText(recurso.getString("panelCliente"));
        labelPlaca.setText(recurso.getString("labelPlaca"));
        labelMarca.setText(recurso.getString("labelMarca"));
        labelModelo.setText(recurso.getString("labelModelo"));
        labelCedula.setText(recurso.getString("labelCedula"));
        labelNombre.setText(recurso.getString("labelNombre"));
        labelTelefono.setText(recurso.getString("labelTelefono"));
        labelDireccion.setText(recurso.getString("labelDireccion"));
        btnAgregar.setText(recurso.getString("btnAgregar"));
        btnBuscar.setText(recurso.getString("btnBuscar"));
        btnAtras.setText(recurso.getString("btnAtras"));

        Object[] columnas = {recurso.getString("labelNombre"), recurso.getString("labelCedula"),
            recurso.getString("labelTelefono"), recurso.getString("labelDireccion")};
        for (int i = 0; i < columnas.length; i++) {
            JTableHeader head = tblClientes.getTableHeader();
            TableColumnModel columnaModelo = head.getColumnModel();
            TableColumn columna = columnaModelo.getColumn(i);
            columna.setHeaderValue(columnas[i]);
        }
        tblClientes.repaint();

    }

    public int cambiarJOption(String idioma, String localizacion) {

        int opcion = 0;
        if (idioma.equals("es")) {
            Object[] botones = {"Si", "No", "Cancelar"};
            opcion = JOptionPane.showOptionDialog(this, "Cliente no encontrado, "
                    + "¿Desea crear un nuevo cliente?", "Mensaje", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
        } else {
            opcion = JOptionPane.showConfirmDialog(this, "Do you want to create a new customer?");
        }

        return opcion;
    }

    public void llenarTBLClientes() {
        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setRowCount(0);

        Set<Cliente> clientes = controladorCliente.findAll();
        Iterator<Cliente> it = clientes.iterator();
        while (it.hasNext()) {
            Cliente c = it.next();
            Object[] objeto = {c.getNombre(), c.getCedula(), c.getTelefono().getNumero(),
                c.getDireccion().toString()};
            modelo.addRow(objeto);
        }
        tblClientes.setModel(modelo);
    }

    public void llenartblClientesCliente(Cliente cliente) {
        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setRowCount(0);

        Object[] objeto = {cliente.getNombre(), cliente.getCedula(), cliente.getTelefono().getNumero(),
            cliente.getDireccion().toString()};
        modelo.addRow(objeto);
        tblClientes.setModel(modelo);
    }

    public void cambiarJOptionPane1() {

        if (localizacion.getLanguage().equals("es")) {
            JOptionPane.showMessageDialog(this, "Llene el campo cedula para buscar un cliente");
        } else {
            JOptionPane.showMessageDialog(this, "Fill the field ID to search a customer");
        }

    }

    public void cambiarJOptionPane2() {

        if (localizacion.getLanguage().equals("es")) {
            JOptionPane.showMessageDialog(this, "Llene todos los requerimientos para crear un nuevo vehiculo");
        } else {
            JOptionPane.showMessageDialog(this, "Fill all the fields to create a new car");
        }

    }

    public void cambiarJOptionPane3() {

        if (localizacion.getLanguage().equals("es")) {
            JOptionPane.showMessageDialog(this, "El vehiculo ya existe");
        } else {
            JOptionPane.showMessageDialog(this, "The car is already in the system");
        }

    }

    public void cambiarJOptionPane4() {

        if (localizacion.getLanguage().equals("es")) {
            JOptionPane.showMessageDialog(this, "Vehiculo creado con exito");
        } else {
            JOptionPane.showMessageDialog(this, "The car has been created with success");
        }

    }

    public void cambiarJOptionPane5() {

        if (localizacion.getLanguage().equals("es")) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente para añadir el vehiculo");
        } else {
            JOptionPane.showMessageDialog(this, "Choose a customer to add the new car");
        }

    }

    /*
    public void cambiarIdioma(String idioma, String localizacion) {
       // placa.setText(recurso.getString("placa"));
        marca.setText(recurso.getString("marca"));
        modelo.setText(recurso.getString("modelo"));
        cedula.setText(recurso.getString("cedula"));
        nombre.setText(recurso.getString("nombre"));
        telefono.setText(recurso.getString("telefono"));
        direccion.setText(recurso.getString("direccion"));
        btnBuscar.setText(recurso.getString("btnBuscar"));
        btnAgregar.setText(recurso.getString("btnAgregar"));
        btnAtras.setText(recurso.getString("tbnAtras"));

    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatosVehiculo = new javax.swing.JPanel();
        labelPlaca = new javax.swing.JLabel();
        txtFormatedPlaca = new javax.swing.JFormattedTextField();
        labelMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        labelModelo = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        panelAñadirCliente = new javax.swing.JPanel();
        labelCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        labelNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        labelTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        labelDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        labelDatosVehiculo = new javax.swing.JLabel();
        labelCliente = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setResizable(true);
        setTitle("Registrar Vehículo");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        panelDatosVehiculo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 12))); // NOI18N

        labelPlaca.setText("Placa:");

        try {
            txtFormatedPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        labelMarca.setText("Marca:");

        labelModelo.setText("Modelo:");

        javax.swing.GroupLayout panelDatosVehiculoLayout = new javax.swing.GroupLayout(panelDatosVehiculo);
        panelDatosVehiculo.setLayout(panelDatosVehiculoLayout);
        panelDatosVehiculoLayout.setHorizontalGroup(
            panelDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosVehiculoLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(panelDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPlaca)
                    .addComponent(labelMarca)
                    .addComponent(labelModelo))
                .addGap(72, 72, 72)
                .addGroup(panelDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFormatedPlaca)
                    .addComponent(txtMarca)
                    .addComponent(txtModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        panelDatosVehiculoLayout.setVerticalGroup(
            panelDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPlaca)
                    .addComponent(txtFormatedPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMarca))
                .addGap(18, 18, 18)
                .addGroup(panelDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelModelo)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cédula", "Teléfono", "Dirección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        panelAñadirCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 12))); // NOI18N

        labelCedula.setText("Cédula:");

        btnBuscar.setBackground(new java.awt.Color(102, 102, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        labelNombre.setText("Nombre:");

        txtNombre.setEditable(false);
        txtNombre.setBackground(new java.awt.Color(102, 102, 102));

        labelTelefono.setText("Teléfono:");

        txtTelefono.setEditable(false);
        txtTelefono.setBackground(new java.awt.Color(102, 102, 102));

        labelDireccion.setText("Dirección:");

        txtDireccion.setEditable(false);
        txtDireccion.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout panelAñadirClienteLayout = new javax.swing.GroupLayout(panelAñadirCliente);
        panelAñadirCliente.setLayout(panelAñadirClienteLayout);
        panelAñadirClienteLayout.setHorizontalGroup(
            panelAñadirClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAñadirClienteLayout.createSequentialGroup()
                .addGroup(panelAñadirClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAñadirClienteLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(btnBuscar))
                    .addGroup(panelAñadirClienteLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(panelAñadirClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAñadirClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelCedula)
                                .addComponent(labelNombre))
                            .addComponent(labelTelefono)
                            .addComponent(labelDireccion))
                        .addGap(86, 86, 86)
                        .addGroup(panelAñadirClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre)
                            .addComponent(txtCedula)
                            .addComponent(txtTelefono)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelAñadirClienteLayout.setVerticalGroup(
            panelAñadirClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAñadirClienteLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelAñadirClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAñadirClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAñadirClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAñadirClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addContainerGap())
        );

        btnAgregar.setBackground(new java.awt.Color(102, 102, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnAtras.setBackground(new java.awt.Color(255, 0, 0));
        btnAtras.setText("Atrás");
        btnAtras.setToolTipText("Cerrar esta ventana y volver al menú principal");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        labelDatosVehiculo.setText("Información del Vehículo");

        labelCliente.setText("Añadir a");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(btnAgregar)
                        .addGap(152, 152, 152)
                        .addComponent(btnAtras))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelDatosVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDatosVehiculo)
                            .addComponent(panelAñadirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCliente))
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelDatosVehiculo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelDatosVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCliente)
                        .addGap(4, 4, 4)
                        .addComponent(panelAñadirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnAtras))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

        String cedulas = txtCedula.getText();

        if (cedulas.isEmpty()) {
            cambiarJOptionPane1();
        } else {
            Cliente c = controladorCliente.buscarCliente(cedulas);
            if (c == null) {
                System.out.println(localizacion.getLanguage() + localizacion.getCountry());
                int opcion = cambiarJOption(localizacion.getLanguage(), localizacion.getCountry());
                /* if (localizacion.getDisplayLanguage().equals("es")) {
                    Object[] botones = {"Si", "No", "Cancelar"};
                    opcion = JOptionPane.showOptionDialog(this, "Cliente no encontrado, "
                            + "¿Desea crear un nuevo cliente?", "Mensaje", JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
                } else {
                    opcion = JOptionPane.showConfirmDialog(this, "Do you want to create a new customer?");
                }*/

                if (opcion == JOptionPane.YES_OPTION) {
                    ventanaRegistarCliente.setVisible(true);
                    this.hide();
                    //llenarTBLClientes();
                }
            } else if (c != null) {
                txtNombre.setText(c.getNombre());
                txtTelefono.setText(c.getTelefono().getNumero());
                txtDireccion.setText(c.getDireccion().toString());
                // llenartblClientesCliente(c);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:

        String placas = txtFormatedPlaca.getText();
        String marcas = txtMarca.getText();
        String modelos = txtModelo.getText();
        String cedulas = txtCedula.getText();

        if (placas.isEmpty() || marcas.isEmpty() || modelos.isEmpty() || cedulas.isEmpty()) {
            cambiarJOptionPane2();
        } else {
            Cliente c = controladorCliente.buscarCliente(cedulas);
            if (c != null) {
                Vehiculo ve = controladorVehiculo.crearVehiculo(placas, marcas, modelos);
                System.out.println(ve);

                if (ve == null) {
                    cambiarJOptionPane3();
                } else {
                    controladorCliente.agregarVehiculo(ve, cedulas);
                    cambiarJOptionPane4();
                    limpiar();
                    this.hide();
                }
            } else {
                cambiarJOptionPane5();
            }
            /*
            controladorCliente.agregarVehiculo(ve, cedulas);
            JOptionPane.showMessageDialog(this, "Vehículo creado con exito");
            this.hide();
            limpiar();*/
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        llenarTBLClientes();
    }//GEN-LAST:event_formInternalFrameActivated

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:

        limpiar();
        this.hide();

    }//GEN-LAST:event_btnAtrasActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        // TODO add your handling code here:

        txtNombre.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");

        int index = tblClientes.getSelectedRow();

        String ced = tblClientes.getValueAt(index, 1).toString();

        Cliente c = controladorCliente.buscarCliente(ced);
        txtCedula.setText("");

        txtCedula.setText(tblClientes.getValueAt(index, 1).toString());
        txtNombre.setText(tblClientes.getValueAt(index, 0).toString());
        txtTelefono.setText(tblClientes.getValueAt(index, 2).toString());
        txtDireccion.setText(tblClientes.getValueAt(index, 3).toString());
    }//GEN-LAST:event_tblClientesMouseClicked

    public void limpiar() {

        txtFormatedPlaca.setValue("");
        txtMarca.setText("");
        txtModelo.setText("");

        txtCedula.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCedula;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelDatosVehiculo;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelModelo;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPlaca;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JPanel panelAñadirCliente;
    private javax.swing.JPanel panelDatosVehiculo;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JFormattedTextField txtFormatedPlaca;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
