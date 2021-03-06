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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Adolfo
 */
public class VentanaListarTickets extends javax.swing.JInternalFrame {

    private ControladorCliente controladorCliente;
    private ControladorVehiculo controladorVehiculo;
    private ControladorTicket controladorTicket;

    private Locale localizacion;
    private ResourceBundle recurso;

    private Set<Ticket> tickets;

    /**
     * Creates new form VentanaListarTickets
     *
     * @param controladorCliente
     * @param controladorVehiculo
     * @param controladorTicket
     */
    public VentanaListarTickets(ControladorCliente controladorCliente, ControladorVehiculo controladorVehiculo,
            ControladorTicket controladorTicket) {

        initComponents();

        this.controladorCliente = controladorCliente;
        this.controladorTicket = controladorTicket;
        this.controladorVehiculo = controladorVehiculo;

        tickets = new HashSet<>();
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
        this.setTitle(recurso.getString("ventanaListarTicket"));
        labelNumeroDeTicket.setText(recurso.getString("labelNumeroDeTicket"));
        btnBuscar.setText(recurso.getString("btnBuscar"));
        btnLimpiar.setText(recurso.getString("btnLimpiar"));
        btnAtras.setText((recurso.getString("btnAtras")));

        Object[] columnas = {recurso.getString("labelNumero"), recurso.getString("labelFechaDeEntrada"),
            recurso.getString("labelFechaDeSalida"), recurso.getString("labelTiempoDeParqueo"),
            recurso.getString("labelTotalPagar"), recurso.getString("labelPlaca"),
            recurso.getString("labelMarca"), recurso.getString("labelModelo"),
            recurso.getString("labelNombre"), recurso.getString("labelCedula"), recurso.getString("labelTelefono"),
            recurso.getString("labelDireccion")};

        for (int i = 0; i < columnas.length; i++) {
            JTableHeader head = tblTickets.getTableHeader();
            TableColumnModel columnaModelo = head.getColumnModel();
            TableColumn columna = columnaModelo.getColumn(i);
            columna.setHeaderValue(columnas[i]);
        }
        tblTickets.repaint();

    }

    public void llenartblTickets() {

        DefaultTableModel modelo = (DefaultTableModel) tblTickets.getModel();
        modelo.setRowCount(0);

        tickets = controladorTicket.findAll();
        Iterator<Ticket> it = tickets.iterator();
        while (it.hasNext()) {
            Ticket t = it.next();
            
            Vehiculo ve = controladorVehiculo.buscarPorTicket(t);
            Cliente c = controladorCliente.buscarPorVehiculo(ve.getPlaca());

            Object[] rowData = {"#", t.getFechaEntrada(), t.getFechaSalida(),
                t.getTiempo(), t.getTotal(), ve.getPlaca(), ve.getModelo(), ve.getMarca(),
                c.getNombre(), c.getCedula(), c.getTelefono().getNumero(), c.getDireccion().toString()};
            
            System.out.println(Arrays.toString(rowData));
            
            modelo.addRow(rowData);

        }

        tblTickets.setModel(modelo);

    }

    public void llenartblTicektsTicekt(Ticket ticket) {
        DefaultTableModel modelo = (DefaultTableModel) tblTickets.getModel();
        modelo.setRowCount(0);

        Vehiculo ve = controladorVehiculo.buscarPorTicket(ticket);
        Cliente c = controladorCliente.buscarPorVehiculo(ve.getPlaca());

        Object[] rowData = {"##", ticket.getFechaEntrada(), ticket.getFechaSalida(),
            ticket.getTiempo(), ticket.getTotal(), ve.getPlaca(), ve.getModelo(), ve.getMarca(),
            c.getNombre(), c.getCedula(), c.getTelefono().getNumero(), c.getDireccion().toString()};

        modelo.addRow(rowData);

        tblTickets.setModel(modelo);
    }

    public void cambiarJOptionPane1() {

        if (localizacion.getLanguage().equals("es")) {
            JOptionPane.showMessageDialog(this, "Llene el campo requerido para buscar un ticket");
        } else {
            JOptionPane.showMessageDialog(this, "Fill the required field to search a ticket");
        }

    }

    public void cambiarJOptionPane2() {

        if (localizacion.getLanguage().equals("es")) {
            JOptionPane.showMessageDialog(this, "Ticket no encontrado");
        } else {
            JOptionPane.showMessageDialog(this, "The ticket hasn't been found");
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

        btnGroupBusqueda = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        labelNumeroDeTicket = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTickets = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setResizable(true);
        setTitle("Tickets");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
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

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        labelNumeroDeTicket.setText("Número de ticket:");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btnBuscar)
                .addGap(70, 70, 70)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(btnAtras)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labelNumeroDeTicket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumeroDeTicket)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnAtras)
                    .addComponent(btnLimpiar))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        tblTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Fecha entrada", "Fecha salida", "Tiempo", "Precio", "Placa", "Marca", "Modelo", "Cliente", "Cédula", "Teléfono", "Dirección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTickets);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 946, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
        llenartblTickets();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        limpiar();
        this.hide();
        llenartblTickets();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        llenartblTickets();

    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        limpiar();
        llenartblTickets();
    }//GEN-LAST:event_formInternalFrameClosed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

        String num = txtBuscar.getText();

        if (num == null) {
            cambiarJOptionPane1();
        } else {
            int n = Integer.parseInt(num);
            Ticket t = controladorTicket.encontrarTicket(n);
            if (t == null) {
                cambiarJOptionPane2();
            } else {
                llenartblTicektsTicekt(t);
            }
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    public void limpiar() {
        //radiobtnCedula.setSelected(false);
        //radiobtnPlaca.setSelected(false);
        //labelSeleccioneElParametro.setText("Seleccione el parámetro:");
        txtBuscar.setText("");
        // txtBuscar.setEditable(false);
        /*
        DefaultTableModel modelo = (DefaultTableModel) tblTickets.getModel();
        modelo.setRowCount(0);
        tblTickets.setModel(modelo);
         */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.ButtonGroup btnGroupBusqueda;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelNumeroDeTicket;
    private javax.swing.JTable tblTickets;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
