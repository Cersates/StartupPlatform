package com.startup.platform.service;


import com.startup.platform.model.Payment;

import java.util.Set;

public interface PaymentService {
    void addPayment(Payment payment);

    Set<Payment> getPayments();

    Payment get(long id);
}