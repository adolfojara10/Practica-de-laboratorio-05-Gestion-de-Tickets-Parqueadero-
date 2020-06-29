/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.vista;

import ec.ups.edu.controlador.ControladorCliente;
import ec.ups.edu.controlador.ControladorTicket;
import ec.ups.edu.controlador.ControladorVehiculo;
import ec.ups.edu.modelo.Cliente;
import ec.ups.edu.modelo.Ticket;
import ec.ups.edu.modelo.Vehiculo;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Adolfo
 */
public class VentanaRegistrarTicket extends javax.swing.JInternalFrame {

    private Calendar fechaActual;

    private ControladorTicket controladorTicket;
    private ControladorCliente controladorCliente;
    private ControladorVehiculo controladorVehiculo;

    private VentanaRegistrarVehiculo ventanaRegistrarVehiculo;
    private VentanaRegistarCliente ventanaRegistarCliente;

    private Locale localizacion;
    private ResourceBundle recurso;

    /**
     * Creates new form VentanaRegistrarTicket
     */
    public VentanaRegistrarTicket(ControladorTicket controladorTicket, ControladorCliente controladorCliente,
            ControladorVehiculo controladorVehiculo, VentanaRegistrarVehiculo ventanaRegistrarVehiculo,
            VentanaRegistarCliente ventanaRegistarCliente) {
        initComponents();

        this.ventanaRegistrarVehiculo = ventanaRegistrarVehiculo;
        this.ventanaRegistarCliente = ventanaRegistarCliente;

        this.controladorTicket = controladorTicket;
        this.controladorCliente = controladorCliente;
        this.controladorVehiculo = controladorVehiculo;
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
        this.setTitle(recurso.getString("ventanaRegistrarTicket"));
        labelNumero.setText(recurso.getString("labelNumero"));
        labelFechaEntrada.setText(recurso.getString("labelFechaDeEntrada"));
        labelParametroBusqueda.setText(recurso.getString("labelParametroDeBusqueda"));
        labelSeleccioneParametro.setText(recurso.getString("labelSeleccioneParametro"));
        radiobtnCedula.setText(recurso.getString("radiobtnCedula"));
        radiobtnPlaca.setText(recurso.getString("radiobtnPlaca"));
        btnBuscar.setText(recurso.getString("btnBuscar"));
        btnEmitir.setText(recurso.getString("btnEmitir"));
        btnLimpiar.setText(recurso.getString("btnLimpiar"));
        btnAtras.setText(recurso.getString("btnAtras"));
        labelMensajeSeleccion.setText(recurso.getString("labelMensajeSeleccion"));
        
        Object[] columnas = {recurso.getString("labelNombre"), recurso.getString("labelCedula"),
            recurso.getString("labelPlaca"), recurso.getString("labelMarca"), recurso.getString("labelModelo")};
        
        for (int i = 0; i < columnas.length; i++) {
            JTableHeader head = tblInformacion.getTableHeader();
            TableColumnModel columnaModelo = head.getColumnModel();
            TableColumn columna = columnaModelo.getColumn(i);
            columna.setHeaderValue(columnas[i]);
        }
        tblInformacion.repaint();
    }

    public int cambiarJOptionCliente(String idioma, String localizacion) {

        int opcion = 0;
        if (idioma.equals("es")) {
            Object[] botones = {"Si", "No", "Cancelar"};
            opcion = JOptionPane.showOptionDialog(this, "Cliente no encontrado, "
                    + "¿Desea crear un nuevo cliente?", "Mensaje", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
        } else {
            opcion = JOptionPane.showConfirmDialog(this, "The Customer hasn't been found,"
                    + " do you want to create a new customer?");
        }

        return opcion;
    }

    public int cambiarJOptionVehiculo(String idioma, String localizacion) {

        int opcion = 0;
        if (idioma.equals("es")) {
            Object[] botones = {"Si", "No", "Cancelar"};
            opcion = JOptionPane.showOptionDialog(this, "Vehiculo no encontrado, "
                    + "¿Desea crear un nuevo vehiculo?", "Mensaje", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
        } else {
            opcion = JOptionPane.showConfirmDialog(this, "The Car hasn't been found, "
                    + "do you want to create a new car?");
        }

        return opcion;
    }

    public void ponerFecha() {
        fechaActual = Calendar.getInstance();
        txtFechaEntrada.setText(fechaActual.getTime().toString());
    }

    public void cargarNumero() {
        int num = controladorTicket.numeroTicket();
        String num2 = String.valueOf(num);
        txtNumero.setText(num2);
    }

    public void llenartblInformacion(Cliente c) {
        DefaultTableModel modelo = (DefaultTableModel) tblInformacion.getModel();
        modelo.setRowCount(0);

        for (Vehiculo ve : c.getListaVehiculos()) {
            Object[] rowData = {c.getNombre(), c.getCedula(), ve.getPlaca(), ve.getMarca(),
                ve.getModelo()};
            modelo.addRow(rowData);
        }
        tblInformacion.setModel(modelo);
    }

    public void llenartblInformacionPorPlaca(Cliente c, Vehiculo ve) {
        DefaultTableModel modelo = (DefaultTableModel) tblInformacion.getModel();
        modelo.setRowCount(0);

        Object[] rowData = {c.getNombre(), c.getCedula(), ve.getPlaca(), ve.getMarca(),
            ve.getModelo()};
        modelo.addRow(rowData);

        tblInformacion.setModel(modelo);
    }

    public void cambiarJOptionPane1() {

        if (localizacion.getLanguage().equals("es")) {
            JOptionPane.showMessageDialog(this, "Llene el campo requerido para buscar un cliente o un vehiculo");
        } else {
            JOptionPane.showMessageDialog(this, "Fill the required field to search a customer or a car");
        }

    }

    public void cambiarJOptionPane2() {

        if (localizacion.getLanguage().equals("es")) {
            JOptionPane.showMessageDialog(this, "Ticket emitido con exito");
        } else {
            JOptionPane.showMessageDialog(this, "The ticket has been issued with succes");
        }

    }

    /*
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
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupBuscar = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        labelNumero = new javax.swing.JLabel();
        labelFechaEntrada = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtFechaEntrada = new javax.swing.JTextField();
        labelParametroBusqueda = new javax.swing.JLabel();
        radiobtnCedula = new javax.swing.JRadioButton();
        radiobtnPlaca = new javax.swing.JRadioButton();
        labelSeleccioneParametro = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEmitir = new javax.swing.JButton();
        txtFormatedParametro = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInformacion = new javax.swing.JTable();
        labelMensajeSeleccion = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setResizable(true);
        setTitle("Emitir Ticket");
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

        labelNumero.setText("Número:");

        labelFechaEntrada.setText("Fecha entrada:");

        txtNumero.setEditable(false);
        txtNumero.setBackground(new java.awt.Color(102, 102, 102));

        txtFechaEntrada.setEditable(false);
        txtFechaEntrada.setBackground(new java.awt.Color(102, 102, 102));

        labelParametroBusqueda.setText("Parámetro de busqueda: ");

        btnGroupBuscar.add(radiobtnCedula);
        radiobtnCedula.setText("Cédula");
        radiobtnCedula.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        radiobtnCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtnCedulaActionPerformed(evt);
            }
        });

        btnGroupBuscar.add(radiobtnPlaca);
        radiobtnPlaca.setText("Placa");
        radiobtnPlaca.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        radiobtnPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtnPlacaActionPerformed(evt);
            }
        });

        labelSeleccioneParametro.setText("Seleccione parámetro:");

        btnBuscar.setBackground(new java.awt.Color(102, 102, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAtras.setBackground(new java.awt.Color(255, 0, 0));
        btnAtras.setText("Atrás");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(255, 51, 51));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEmitir.setBackground(new java.awt.Color(102, 102, 255));
        btnEmitir.setText("Emitir");
        btnEmitir.setEnabled(false);
        btnEmitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirActionPerformed(evt);
            }
        });

        txtFormatedParametro.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addGap(34, 34, 34)
                        .addComponent(btnEmitir)
                        .addGap(38, 38, 38)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtras))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNumero)
                            .addComponent(labelFechaEntrada)
                            .addComponent(labelSeleccioneParametro)
                            .addComponent(labelParametroBusqueda))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFormatedParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radiobtnPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(radiobtnCedula))))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFechaEntrada)
                    .addComponent(txtFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelParametroBusqueda)
                    .addComponent(radiobtnCedula))
                .addGap(12, 12, 12)
                .addComponent(radiobtnPlaca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSeleccioneParametro)
                    .addComponent(txtFormatedParametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnAtras)
                    .addComponent(btnLimpiar)
                    .addComponent(btnEmitir))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tblInformacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Cédula", "Placa", "Marca", "Modelo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblInformacion);

        labelMensajeSeleccion.setText("Seleccione el vehiculo a asignar el ticket");
        labelMensajeSeleccion.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(labelMensajeSeleccion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(labelMensajeSeleccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        ponerFecha();
        cargarNumero();
    }//GEN-LAST:event_formInternalFrameActivated

    private void radiobtnCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtnCedulaActionPerformed
        // TODO add your handling code here:

        try {
            txtFormatedParametro.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(
                            new javax.swing.text.MaskFormatter("AAAAAAAAAA")
                    )
            );
        } catch (java.text.ParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato del número de cedula erroneo");
            ex.printStackTrace();
        }

        radiobtnPlaca.setSelected(false);
        labelSeleccioneParametro.setText("Cédula:");
        txtFormatedParametro.setEditable(true);

    }//GEN-LAST:event_radiobtnCedulaActionPerformed

    private void radiobtnPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtnPlacaActionPerformed
        // TODO add your handling code here:

        try {
            txtFormatedParametro.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(
                            new javax.swing.text.MaskFormatter("UUU-####")
                    )
            );
        } catch (java.text.ParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato del número de placa erroneo");
            ex.printStackTrace();
        }

        radiobtnCedula.setSelected(false);
        labelSeleccioneParametro.setText("Placa:");
        txtFormatedParametro.setEditable(true);
    }//GEN-LAST:event_radiobtnPlacaActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        limpiar();
        this.hide();

    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
        ponerFecha();


    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

        String buscars = txtFormatedParametro.getText();

        String numero = txtNumero.getText();
        String fecha = txtFechaEntrada.getText();

        if (buscars == null) {
            cambiarJOptionPane1();

        } else {
            if (radiobtnCedula.isSelected()) {
                Cliente c = controladorCliente.buscarCliente(buscars);
                if (c == null) {
                    int op = cambiarJOptionCliente(localizacion.getLanguage(), localizacion.getCountry());
                    if (op == JOptionPane.YES_OPTION) {
                        ventanaRegistarCliente.setVisible(true);
                        this.hide();
                    }
                } else {
                    labelMensajeSeleccion.setEnabled(true);
                    llenartblInformacion(c);
                    btnEmitir.setEnabled(true);
                }
            } else if (radiobtnPlaca.isSelected()) {
                Vehiculo v = controladorVehiculo.buscarVehiculo(buscars);
                if (v == null) {
                    int op = cambiarJOptionVehiculo(localizacion.getLanguage(), localizacion.getCountry());
                    if (op == JOptionPane.YES_OPTION) {
                        ventanaRegistrarVehiculo.setVisible(true);
                        this.hide();
                    }
                } else {
                    Cliente c = controladorCliente.buscarPorVehiculo(v.getPlaca());
                    labelMensajeSeleccion.setEnabled(true);
                    llenartblInformacionPorPlaca(c, v);
                    btnEmitir.setEnabled(true);
                }
            }
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirActionPerformed
        // TODO add your handling code here:
        String num = txtNumero.getText();
        int num2 = Integer.parseInt(num);
        Date entrada = fechaActual.getTime();

        Ticket t = controladorTicket.crear(num2, entrada);

        int row = tblInformacion.getSelectedRow();

        String placa = tblInformacion.getValueAt(row, 2).toString();
        String cedulas = tblInformacion.getValueAt(row, 1).toString();

        Vehiculo ve = controladorVehiculo.buscarVehiculo(placa);
        ve.agregarTicket(t);
        Cliente c = controladorCliente.buscarCliente(cedulas);

        controladorCliente.actualizarVehiculo(c, ve);
        cambiarJOptionPane2();

        limpiar();
        this.hide();
    }//GEN-LAST:event_btnEmitirActionPerformed

    public void limpiar() {
        labelSeleccioneParametro.setText("Seleccione parámetro:");
        btnGroupBuscar.clearSelection();
        radiobtnCedula.setSelected(false);
        radiobtnPlaca.setSelected(false);
        txtFormatedParametro.setValue("");
        txtFormatedParametro.setEditable(false);
        DefaultTableModel modelo = (DefaultTableModel) tblInformacion.getModel();
        modelo.setRowCount(0);
        tblInformacion.setModel(modelo);
        btnEmitir.setEnabled(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEmitir;
    private javax.swing.ButtonGroup btnGroupBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFechaEntrada;
    private javax.swing.JLabel labelMensajeSeleccion;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelParametroBusqueda;
    private javax.swing.JLabel labelSeleccioneParametro;
    private javax.swing.JRadioButton radiobtnCedula;
    private javax.swing.JRadioButton radiobtnPlaca;
    private javax.swing.JTable tblInformacion;
    private javax.swing.JTextField txtFechaEntrada;
    private javax.swing.JFormattedTextField txtFormatedParametro;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
