package com.example.flymanager.repository;

import com.example.flymanager.model.Ticket;

import java.util.List;

public interface TicketRepository extends BaseRepository<Ticket, Long>{

    boolean isAvailableTicket(Long ticketId);


}
