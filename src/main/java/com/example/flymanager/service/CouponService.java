package com.example.flymanager.service;

import com.example.flymanager.exception.EntityNotFoundException;
import com.example.flymanager.model.Coupon;
import com.example.flymanager.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class CouponService {

    private final CouponRepository couponRepository;


    public double calculate(double ticketPrice, Long couponId) {
        Coupon coupon = couponRepository.getById(couponId);
        isCouponExist(coupon, couponId);

        double discount = ticketPrice / 100 * coupon.getDiscount().getValue();
        return ticketPrice - discount;
    }

    private void isCouponExist(Coupon coupon, Long couponId) {
        if (Objects.isNull(coupon)) {
            throw new EntityNotFoundException(String.format("Coupon with id : %d not found", couponId));
        }
    }
}
