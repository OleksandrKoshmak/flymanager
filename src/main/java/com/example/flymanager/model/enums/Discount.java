package com.example.flymanager.model.enums;

public enum Discount {
    TEN_PERCENT(10),
    FIFTY_PERCENT(50),
    SIXTY_PERCENT(60);

    private final int value;

    Discount(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
