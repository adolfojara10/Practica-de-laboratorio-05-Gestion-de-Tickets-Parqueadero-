/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.controlador;

import ec.ups.edu.dao.ClienteDAO;
import ec.ups.edu.dao.VehiculoDAO;
import ec.ups.edu.idao.IClienteDAO;
import ec.ups.edu.idao.IVehiculoDAO;
import ec.ups.edu.modelo.Cliente;
import ec.ups.edu.modelo.Direccion;
import ec.ups.edu.modelo.Telefono;
import ec.ups.edu.modelo.Vehiculo;

/**
 *
 * @author Adolfo
 */
public class ControladorCliente {

    private Cliente cliente;
    private Vehiculo vehiculo;

    private IClienteDAO clienteDAO;
    private IVehiculoDAO vehiculaDAO;

    public ControladorCliente(ClienteDAO clienteDAO, VehiculoDAO vehiculaDAO) {
        this.clienteDAO = clienteDAO;
        this.vehiculaDAO = vehiculaDAO;
    }

    public boolean crearCliente(String cedula, String nombre, Telefono telefono, Direccion direccion) {

        cliente = new Cliente(cedula, nombre, telefono, direccion);
        if (clienteDAO.create(cliente)) {
            return true;
        } else {
            return false;
        }
    }

    
    
    public boolean agregarVehiculo(String placa, String marca, String modelo){
        vehiculo = new Vehiculo(placa, marca, modelo);
        if(vehiculaDAO.create(vehiculo)){
            cliente.agregarVehiculo(vehiculo);
            clienteDAO.update(cliente);
            return true;
        } else {
            return false;
        }
    }
    
    
    
    
    
    
    public Cliente burcarCliente(String cedula) {
        cliente = clienteDAO.read(cedula);
        return cliente;
    }

}
