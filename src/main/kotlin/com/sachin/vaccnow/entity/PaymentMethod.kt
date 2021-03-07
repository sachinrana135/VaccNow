package com.sachin.vaccnow.entity

enum class PaymentMethod(val value: String) {
    CASH("cash"),
    CREDIT("credit"),
    FAWRY("fawry");

    companion object {
        fun from(s: String): PaymentMethod? = values().find { it.value == s }
    }

}

