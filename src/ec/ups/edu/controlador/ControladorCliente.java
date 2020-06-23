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
    private IVehiculoDAO vehiculoDAO;

    public ControladorCliente(ClienteDAO clienteDAO, VehiculoDAO vehiculoDAO) {
        this.clienteDAO = clienteDAO;
        this.vehiculoDAO = vehiculoDAO;
    }

    public boolean crearCliente(String cedula, String nombre,String tipo, String numeroT, String operadora, 
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

    
    
    public boolean agregarVehiculo(String placa, String marca, String modelo){
        vehiculo = new Vehiculo(placa, marca, modelo);
        if(vehiculoDAO.create(vehiculo)){
            cliente.agregarVehiculo(vehiculo);
            clienteDAO.update(cliente);
            return true;
        } else {
            return false;
        }
    }
    
    
    
    
    
    
    public Cliente buscarCliente(String cedula) {
        cliente = clienteDAO.read(cedula);
        return cliente;
    }

}
