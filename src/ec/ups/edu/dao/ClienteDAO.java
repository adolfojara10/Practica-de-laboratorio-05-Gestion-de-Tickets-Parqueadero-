/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.dao;

import ec.ups.edu.idao.IClienteDAO;
import ec.ups.edu.modelo.Cliente;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Adolfo
 */
public class ClienteDAO implements IClienteDAO{

    private Set<Cliente> clientes;
    public ClienteDAO (){
    clientes = new HashSet<Cliente>();
    }
    @Override
    public void create(Cliente cliente) {
    clientes.add(cliente);
    }

    @Override
    public Cliente read(String cedula) {
   return null;
    }

    @Override
    public void update(Cliente cliente) {

    }

    @Override
    public void delete(Cliente cliente) {

    }

    @Override
    public Set<Cliente> findAll() {
    return clientes;
    }
    
    
    
}
