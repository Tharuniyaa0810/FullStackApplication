package com.astrasquad.tharuniyaa.model.enumerate;


public enum CurrencyType {
    USD("US Dollar"),
    EUR("Euro"),
    GBP("British Pound"),
    JPY("Japanese Yen"),
    AUD("Australian Dollar"),
    CAD("Canadian Dollar"),
    INR("Indian Rupee");

    private final String displayName;

    CurrencyType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

