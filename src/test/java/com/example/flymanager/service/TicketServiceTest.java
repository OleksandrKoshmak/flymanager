package com.example.flymanager.service;

import com.example.flymanager.model.Ticket;
import com.example.flymanager.repository.TicketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(value = MockitoExtension.class)
class TicketServiceTest {
    @Mock
    TicketRepository repository;

    @InjectMocks
    private TicketService ticketService;


    private List<Ticket> ticketList;

    @BeforeEach
    void setUp() {
        ticketList = new ArrayList<>();
        ticketList.add(new Ticket(1L, true, 50));
        ticketList.add(new Ticket(2L, false,100));
        ticketList.add(new Ticket(3L, true, 300));
        ticketList.add(new Ticket(4L, false, 20));
        ticketList.add(new Ticket(5L, true, 100));
        ticketList.add(new Ticket(6L, false, 450));
        ticketList.add(new Ticket(7L, true, 150));

    }

    @Test
    @DisplayName("Should return all Tickets")
    void getAllTickets() {
        when(repository.getAll()).thenReturn(ticketList);
        List<Ticket> tickets = ticketService.getAllTickets();
        assertEquals(7, tickets.size());

    }

    @Test
    @DisplayName("Should return ticket by Id")
    void getTicketById() {
        when(ticketService.getTicketById(1L)).thenReturn(ticketList.get(1));
        Ticket ticket = ticketService.getTicketById(1L);
        assertEquals(ticket, ticketList.get(1));

    }

    @Test
    @DisplayName("Should throw an Exception")
    void getTicketWithNullId() {
        assertThrows(IllegalArgumentException.class, ()-> ticketService.getTicketById(null));

    }

    @Test
    @DisplayName("Should return ticket's status")
    void isAvailableTicket() {
        when(ticketService.isAvailableTicket(6L)).thenReturn(false);
        boolean status = ticketService.isAvailableTicket(6L);
        assertFalse(status);

    }


}