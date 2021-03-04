package com.sachin.VaccNow.Entity

enum class PaymentMethod(val value: String) {
    CASH("cash"),
    CREDIT("credit"),
    FAWRY("fawry");

    companion object {
        fun from(s: String): PaymentMethod? = values().find { it.value == s }
    }

}

