/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.idao;

import ec.ups.edu.modelo.Ticket;
import java.util.Set;

/**
 *
 * @author Adolfo
 */
public interface ITicketDAO {
    
     public void create(Ticket ticket);
    
    public Ticket read(int numero);
    
    public void update(Ticket ticket);
    
    public void delete(Ticket ticket);
    
    public Set<Ticket> findAll();
}
