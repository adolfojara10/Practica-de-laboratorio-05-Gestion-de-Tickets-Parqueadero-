/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.dao;

import ec.ups.edu.idao.IClienteDAO;
import ec.ups.edu.modelo.Cliente;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Adolfo
 */
public class ClienteDAO implements IClienteDAO {

    private Set<Cliente> clientes;

    public ClienteDAO() {
        clientes = new HashSet<Cliente>();
    }

    @Override
    public boolean create(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Cliente read(String cedula) {
        Iterator<Cliente> it = clientes.iterator();
        while (it.hasNext()) {
            Cliente c = it.next();
            if (c.getCedula().equals(cedula)) {
                return c;
            }
            break;
        }
        return null;
    }

    @Override
    public void update(Cliente cliente) {
        Iterator<Cliente> it = clientes.iterator();

        while (it.hasNext()) {
            Cliente c = it.next();
            if (c.getCedula().equals(cliente.getCedula())) {
                clientes.remove(c);
                clientes.add(cliente);
            }
            break;
        }

    }

    @Override
    public void delete(Cliente cliente) {

        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
        }
        /*Iterator<Cliente> it = clientes.iterator();

        while (it.hasNext()) {
            Cliente c = it.next();
            if (c.equals(cliente.getCedula())) {
                clientes.remove(c);
                clientes.add(cliente);
            }
            break;
        }*/
    }

    @Override
    public Set<Cliente> findAll() {
        return clientes;
    }

}
