package com.startup.platform.dao.impl;

import com.startup.platform.dao.PaymentDAO;
import com.startup.platform.model.Payment;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;

@Repository(value = "paymentDAO")
public class PaymentDAOImpl implements PaymentDAO {

    private AtomicLong idSequence = new AtomicLong(1L);
    private CopyOnWriteArraySet<Payment> storage = new CopyOnWriteArraySet<Payment>() {
        {
            add(new Payment(idSequence.getAndIncrement(), new BigDecimal(100L), 1L, 2L));
            add(new Payment(idSequence.getAndIncrement(), new BigDecimal(200L), 1L, 3L));
        }
    };

    public void savePayment(Payment payment) {
        // generate id
        payment.setId(idSequence.getAndIncrement());
        storage.add(payment);
    }

    public Set<Payment> getPayments() {
        System.out.println("=======aaaaaa"+storage);

        return new HashSet<Payment>(storage);
    }

    public Payment get(long id) {
        for (Payment payment : storage) {
            if (payment.getId() == id) {
                return payment;
            }
        }
        return null; // nothing found
    }
}