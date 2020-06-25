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
import ec.ups.edu.modelo.Ticket;
import ec.ups.edu.modelo.Vehiculo;
import java.util.Date;

/**
 *
 * @author Adolfo
 */
public class ControladorTicket {
    
    
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Ticket ticket;

    private IClienteDAO clienteDAO;
    private IVehiculoDAO vehiculoDAO;
    private ITicketDAO ticketDAO;

    public ControladorTicket(IClienteDAO clienteDAO, IVehiculoDAO vehiculoDAO, ITicketDAO ticketDAO) {
        this.clienteDAO = clienteDAO;
        this.vehiculoDAO = vehiculoDAO;
        this.ticketDAO = ticketDAO;
    }

   
    public Ticket crear(int numero, Date entrada){
        
        ticket = new Ticket(numero, entrada);
        ticketDAO.create(ticket);
        
        return ticket;
    }
    
    public Ticket encontrarTicket(int numero){
        ticket = ticketDAO.read(numero);
        
        return ticket;     
    }
    
    public double calcularPago(Date fechaEntrada, Date fechaSalida){
        
    }
    
    
    public int numeroTicket() {
        int conta = ticketDAO.devolverNumero();
        return (++conta);
    }
}
