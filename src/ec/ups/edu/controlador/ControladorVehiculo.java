/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.controlador;

import ec.ups.edu.dao.VehiculoDAO;
import ec.ups.edu.idao.IVehiculoDAO;
import ec.ups.edu.modelo.Ticket;
import ec.ups.edu.modelo.Vehiculo;

/**
 *
 * @author Adolfo
 */
public class ControladorVehiculo {

    private Vehiculo vehiculo;
    private Ticket ticket;

    private IVehiculoDAO vehiculoDAO;

    public ControladorVehiculo(VehiculoDAO vehiculoDAO) {
        this.vehiculoDAO = vehiculoDAO;
    }

    public Vehiculo crearVehiculo(String placa, String marca, String modelo) {
        vehiculo = new Vehiculo(placa, marca, modelo);
        if (vehiculoDAO.create(vehiculo)) {
            return vehiculo;
        }
        return null;
    }

    public Vehiculo buscarVehiculo(String placa) {

        vehiculo = vehiculoDAO.read(placa);
        if (vehiculo == null) {
            return null;
        } else {
            return vehiculo;
        }
    }

}
