package com.example.flymanager.model;

import com.example.flymanager.model.enums.Discount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {
    private Long couponId;
    private Discount discount;

}
