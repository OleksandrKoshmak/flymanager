package com.example.flymanager.service;

import com.example.flymanager.model.Coupon;
import com.example.flymanager.model.Ticket;
import com.example.flymanager.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketService {

    private final TicketRepository ticketRepository;
    private final CouponService couponService;

    public List<Ticket> getAllTickets() {
        log.info("Send request get all tickets");
        List<Ticket> allTickets = ticketRepository.getAll();
        log.info("Tickets are received");
        return allTickets;
    }

    public Ticket getTicketById(Long ticketId) {
        checkIsNullTicketId(ticketId);
        log.info("Send request get a ticket by id : {}", ticketId);
        Ticket ticket = ticketRepository.getById(ticketId);
        log.info("Ticket is received");
        return ticket;
    }


    public boolean isAvailableTicket(Long ticketId) {
        checkIsNullTicketId(ticketId);
        log.info("Send request check is available ticket by id : {}", ticketId);
        boolean isAvailable = ticketRepository.isAvailableTicket(ticketId);
        log.info("Ticket was checked");
        return isAvailable;
    }

    private void checkIsNullTicketId(Long ticketId) {
        if (Objects.isNull(ticketId)) {
            log.info("Ticket id is null");
            throw new IllegalArgumentException("Ticket id is null");
        }
    }

}
