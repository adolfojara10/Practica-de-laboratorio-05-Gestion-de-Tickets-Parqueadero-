/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.controlador;

import ec.ups.edu.dao.ClienteDAO;
import ec.ups.edu.dao.TicketDAO;
import ec.ups.edu.dao.VehiculoDAO;
import ec.ups.edu.idao.IClienteDAO;
import ec.ups.edu.idao.ITicketDAO;
import ec.ups.edu.idao.IVehiculoDAO;
import ec.ups.edu.modelo.Cliente;
import ec.ups.edu.modelo.Direccion;
import ec.ups.edu.modelo.Telefono;
import ec.ups.edu.modelo.Vehiculo;
import java.util.Set;

/**
 *
 * @author Adolfo
 */
public class ControladorCliente {

    private Cliente cliente;
    private Vehiculo vehiculo;

    private IClienteDAO clienteDAO;
    private IVehiculoDAO vehiculoDAO;
    private ITicketDAO ticketDAO;

    public ControladorCliente(ClienteDAO clienteDAO, VehiculoDAO vehiculoDAO, TicketDAO ticketDAO) {
        this.clienteDAO = clienteDAO;
        this.vehiculoDAO = vehiculoDAO;
        this.ticketDAO = ticketDAO;
    }

    public boolean crearCliente(String cedula, String nombre, String tipo, String numeroT, String operadora,
            String calleP, String calleS, String numeroC) {

        Telefono tele = new Telefono(numeroT, tipo, operadora);
        Direccion dir = new Direccion(calleP, calleS, numeroC);

        cliente = new Cliente(cedula, nombre, tele, dir);
        if (clienteDAO.create(cliente)) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarVehiculo(Vehiculo vehiculo, String cedulas) {
        // vehiculo = new Vehiculo(placa, marca, modelo);
        System.out.println("\n" + vehiculo);
        this.cliente = clienteDAO.read(cedulas);
        // vehiculoDAO.create(vehiculo);
        if (cliente == null || vehiculo == null) {
            System.out.println(cliente);
        } else {
            cliente.agregarVehiculo(vehiculo);
            clienteDAO.update(cliente);
            System.out.println(cliente);
            // System.out.println(cliente);
        }

    }

    public void actualizarVehiculo(Cliente cliente, Vehiculo vehiculo) {
        
        vehiculoDAO.update(vehiculo);
        cliente.actualizarVehiculo(vehiculo);
        clienteDAO.update(cliente);
        System.out.println("\nactualizado:\n" + cliente);
    }

    public Cliente buscarCliente(String cedula) {
        cliente = clienteDAO.read(cedula);
        return cliente;
    }

    public Cliente buscarPorVehiculo(String placa) {
        cliente = clienteDAO.buscarPorVehiculo(placa);
        if (cliente == null) {
            return null;
        } else {
            return cliente;
        }
    }

    public Set<Cliente> findAll() {
        return clienteDAO.findAll();
    }
}
