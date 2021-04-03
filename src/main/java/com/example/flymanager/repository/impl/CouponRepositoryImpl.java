package com.example.flymanager.repository.impl;

import com.example.flymanager.exception.EntityNotFoundException;
import com.example.flymanager.model.Coupon;
import com.example.flymanager.model.enums.Discount;
import com.example.flymanager.repository.CouponRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CouponRepositoryImpl implements CouponRepository {

    List<Coupon> coupons = new ArrayList<>();

    {
        coupons.add(new Coupon(1L, Discount.TEN_PERCENT));
        coupons.add(new Coupon(2L, Discount.FIFTY_PERCENT));
        coupons.add(new Coupon(3L, Discount.SIXTY_PERCENT));
    }

    @Override
    public List<Coupon> getAll() {
        return coupons;
    }

    @Override
    public Coupon getById(Long id) {
        return coupons.
                stream()
                .filter(coupon -> id.equals(coupon.getCouponId()))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(String.format("Coupon with id : %d not found", id)));
    }
}
