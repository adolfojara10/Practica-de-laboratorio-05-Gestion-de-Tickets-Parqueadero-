/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.vista;

import ec.ups.edu.controlador.ControladorCliente;
import ec.ups.edu.controlador.ControladorTicket;
import ec.ups.edu.controlador.ControladorVehiculo;
import ec.ups.edu.modelo.Ticket;
import ec.ups.edu.modelo.Vehiculo;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Adolfo
 */
public class VentanaSalidaTicket extends javax.swing.JInternalFrame {

    private Calendar fechaSalida;

    private ControladorTicket controladorTicket;
    private ControladorVehiculo controladorVehiculo;
    private ControladorCliente controladorCliente;

    /**
     * Creates new form VentanaSalidaTicket
     */
    public VentanaSalidaTicket(ControladorTicket controladorTicket, ControladorVehiculo controladorVehiculo,
            ControladorCliente controladorCliente) {
        initComponents();

        this.controladorTicket = controladorTicket;
        this.controladorVehiculo = controladorVehiculo;
        this.controladorCliente = controladorCliente;
    }

    public void ponerFecha() {
        fechaSalida = Calendar.getInstance();
        txtFechaEntrada.setText(fechaSalida.getTime().toString());
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
        jLabel1 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFechaEntrada = new javax.swing.JTextField();
        txtFechaSalida = new javax.swing.JTextField();
        txtTiempo = new javax.swing.JTextField();
        txtPago = new javax.swing.JTextField();
        btnFactura = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSalidaTicket = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setResizable(true);
        setTitle("Ticket de Salida");

        jLabel1.setText("Escriba el número del ticket:");

        jLabel2.setText("Fecha de entrada:");

        jLabel3.setText("Fecha de salida:");

        jLabel4.setText("Tiempo de parqueo:");

        jLabel5.setText("Total a pagar:");

        txtFechaEntrada.setEditable(false);
        txtFechaEntrada.setBackground(new java.awt.Color(102, 102, 102));

        txtFechaSalida.setEditable(false);
        txtFechaSalida.setBackground(new java.awt.Color(102, 102, 102));

        txtTiempo.setEditable(false);
        txtTiempo.setBackground(new java.awt.Color(102, 102, 102));

        txtPago.setEditable(false);
        txtPago.setBackground(new java.awt.Color(102, 102, 102));

        btnFactura.setBackground(new java.awt.Color(102, 102, 255));
        btnFactura.setText("Emitir Factura");
        btnFactura.setEnabled(false);

        btnLimpiar.setBackground(new java.awt.Color(255, 51, 51));
        btnLimpiar.setText("Limpiar");

        btnAtras.setBackground(new java.awt.Color(255, 0, 0));
        btnAtras.setText("Atrás");

        btnBuscar.setBackground(new java.awt.Color(102, 102, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnFactura)
                .addGap(49, 49, 49)
                .addComponent(btnLimpiar)
                .addGap(47, 47, 47)
                .addComponent(btnAtras)
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaEntrada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaSalida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTiempo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFactura)
                    .addComponent(btnLimpiar)
                    .addComponent(btnAtras)
                    .addComponent(btnBuscar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tblSalidaTicket.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblSalidaTicket);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

        String num = txtNumero.getText();

        if (num == null) {
            JOptionPane.showMessageDialog(this, "Llene el campo de número para buscar un ticket");
        } else {
            int num2 = Integer.parseInt(num);
            Ticket t = controladorTicket.encontrarTicket(num2);
            if (t == null) {
                JOptionPane.showMessageDialog(this, "Ticket no encontrado, intentelo otra vez");
            } else {
                txtFechaEntrada.setText(t.getFechaEntrada().toString());
                ponerFecha();

                Date fechaS = Calendar.getInstance().getTime();
                double tiempo = controladorTicket.calcularTiempo(t.getFechaEntrada(), fechaS);
                
                String totalTiempo = controladorTicket.calcularHorasMinutos(tiempo);
                txtTiempo.setText(totalTiempo);
                
                double pago = controladorTicket.calcularPago(tiempo);

                Vehiculo ve = controladorVehiculo.buscarPorTicket(t);
            }

        }

    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSalidaTicket;
    private javax.swing.JTextField txtFechaEntrada;
    private javax.swing.JTextField txtFechaSalida;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextField txtTiempo;
    // End of variables declaration//GEN-END:variables
}
