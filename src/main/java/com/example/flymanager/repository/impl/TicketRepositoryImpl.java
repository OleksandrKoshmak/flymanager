package com.example.flymanager.repository.impl;

import com.example.flymanager.exception.EntityNotFoundException;
import com.example.flymanager.model.Ticket;
import com.example.flymanager.repository.TicketRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketRepositoryImpl implements TicketRepository {


    private final List<Ticket> tableTickets = new ArrayList<>();

    {
        tableTickets.add(new Ticket(1L, true, 50));
        tableTickets.add(new Ticket(2L, false,100));
        tableTickets.add(new Ticket(3L, true, 300));
        tableTickets.add(new Ticket(4L, false, 20));
        tableTickets.add(new Ticket(5L, true, 100));
        tableTickets.add(new Ticket(6L, false, 450));
        tableTickets.add(new Ticket(7L, true, 150));
    }

    @Override
    public List<Ticket> getAll() {
        return tableTickets;
    }

    @Override
    public Ticket getById(Long id) {
        return tableTickets.stream()
                .filter(ticket -> id.equals(ticket.getTicketId()))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(String.format("Ticket with id : %d not found", id)));
    }

    @Override
    public boolean isAvailableTicket(Long ticketId) {
        return getById(ticketId).isAvailable();

    }
}
