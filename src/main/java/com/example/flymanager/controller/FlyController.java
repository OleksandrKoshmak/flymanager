package com.example.flymanager.controller;

import com.example.flymanager.service.CouponService;
import com.example.flymanager.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/fly")
public class FlyController {

    private final TicketService ticketService;
    private final CouponService couponService;

    @GetMapping(value = "/tickets")
    public ResponseEntity<Boolean> isAvailableTicket(Long ticketId) {
        return new ResponseEntity<>(ticketService.isAvailableTicket(ticketId), HttpStatus.OK);
    }

    @PostMapping(value = "/coupons")
    public ResponseEntity<Double> calculateDiscount(Double price, Long couponId) {
        return new ResponseEntity<>(couponService.calculate(price, couponId), HttpStatus.OK);
    }

}
