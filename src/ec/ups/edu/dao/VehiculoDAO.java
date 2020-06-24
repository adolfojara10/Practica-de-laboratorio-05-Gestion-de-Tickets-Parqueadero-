/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.dao;

import ec.ups.edu.idao.IVehiculoDAO;
import ec.ups.edu.modelo.Vehiculo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Adolfo
 */
public class VehiculoDAO implements IVehiculoDAO {

    private Set<Vehiculo> vehiculos;

    public VehiculoDAO() {
        vehiculos = new HashSet<>();
    }

    @Override
    public boolean create(Vehiculo vehiculo) {
        if (!vehiculos.contains(vehiculo)) {
            vehiculos.add(vehiculo);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Vehiculo read(String placa) {
        Iterator<Vehiculo> it = vehiculos.iterator();
        while (it.hasNext()) {
            Vehiculo v = it.next();
            if (v.getPlaca().equals(placa)) {
                return v;
            }
            break;
        }
        return null;
    }

    @Override
    public void update(Vehiculo vehiculo) {
        Iterator<Vehiculo> it = vehiculos.iterator();
        while (it.hasNext()) {
            Vehiculo v = it.next();
            if (v.getPlaca().equals(vehiculo.getPlaca())) {
                vehiculos.remove(v);
                vehiculos.add(vehiculo);
            }
            break;
        }
    }

    @Override
    public void delete(Vehiculo vehiculo) {
        if (vehiculos.contains(vehiculo)) {
            vehiculos.remove(vehiculo);
        }
    }

    @Override
    public Set<Vehiculo> findAll() {
        return vehiculos;
    }

}
