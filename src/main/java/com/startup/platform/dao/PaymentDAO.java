package com.startup.platform.dao;


import com.startup.platform.model.Payment;

import java.util.Set;

public interface PaymentDAO {
    void savePayment(Payment payment);

    Set<Payment> getPayments();

    Payment get(long id);
}
