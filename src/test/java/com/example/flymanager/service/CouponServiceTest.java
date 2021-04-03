package com.example.flymanager.service;

import com.example.flymanager.exception.EntityNotFoundException;
import com.example.flymanager.model.Coupon;
import com.example.flymanager.model.enums.Discount;
import com.example.flymanager.repository.CouponRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CouponServiceTest {

    @Mock
    CouponRepository couponRepository;

    List<Coupon> coupons;

    @InjectMocks
    private CouponService couponService;

    @BeforeEach
    void setUp() {
       coupons = new ArrayList<>();
            coupons.add(new Coupon(1L, Discount.TEN_PERCENT));
            coupons.add(new Coupon(2L, Discount.FIFTY_PERCENT));
            coupons.add(new Coupon(3L, Discount.SIXTY_PERCENT));

    }

    @Test
    @DisplayName("Should return final ticket's price with discount")
    void calculateDiscount() {
        when(couponRepository.getById(1L)).thenReturn(coupons.get(0));

        Double discount = couponService.calculate(100, 1L);

        assertEquals(90, discount);
    }

    @Test
    @DisplayName("Should throw Exception")
    void checkIsThrowException() {
        assertThrows(EntityNotFoundException.class, ()-> couponService.calculate(100, null));
    }
}