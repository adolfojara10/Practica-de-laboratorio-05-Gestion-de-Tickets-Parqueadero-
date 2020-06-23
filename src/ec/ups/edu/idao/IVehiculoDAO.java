/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.idao;

import ec.ups.edu.modelo.Vehiculo;
import java.util.Set;

/**
 *
 * @author Adolfo
 */
public interface IVehiculoDAO {

    public boolean create(Vehiculo vehiculo);

    public Vehiculo read(String placa);

    public void update(Vehiculo vehiculo);

    public void delete(Vehiculo vehiculo);

    public Set<Vehiculo> findAll();
    
   
}
