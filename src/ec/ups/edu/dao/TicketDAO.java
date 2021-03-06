/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.dao;

import ec.ups.edu.idao.ITicketDAO;

import ec.ups.edu.modelo.Ticket;

import java.util.*;

/**
 *
 * @author JHON FAREZ
 */
public class TicketDAO implements ITicketDAO {

    private Set<Ticket> tickets;
    private int numero;

    public TicketDAO() {
        tickets = new HashSet<>();
        numero = 0;
    }

    @Override
    public boolean create(Ticket ticket) {
        ++numero;
        ticket.setNumero(numero);
        if (tickets.contains(ticket) != true) {
            tickets.add(ticket);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Ticket read(int numero) {
        Ticket tt = new Ticket();
        Iterator<Ticket> it = tickets.iterator();
        while (it.hasNext()) {
            Ticket t = it.next();
            if (t.getNumero() == numero) {
                tt = t;
                return t;
            }
        }
        if (tt.getFechaEntrada() != null) {
            return tt;
        } else {
            return null;
        }
    }

    @Override
    public void update(Ticket ticket) {
        Iterator<Ticket> it = tickets.iterator();
        while (it.hasNext()) {
            Ticket t = it.next();
            if (t.getNumero() == ticket.getNumero()) {
                it.remove();

            }
        }
        tickets.add(ticket);
    }

    @Override
    public void delete(Ticket ticket) {
        if (tickets.contains(ticket)) {
            tickets.remove(ticket);
        }
    }

    @Override
    public Set<Ticket> findAll() {
        return tickets;
    }

    @Override
    public int devolverNumero() {
        return numero;
    }

}
