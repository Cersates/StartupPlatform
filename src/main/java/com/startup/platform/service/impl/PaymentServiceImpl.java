package com.startup.platform.service.impl;

import com.startup.platform.dao.PaymentDAO;
import com.startup.platform.model.Payment;
import com.startup.platform.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service(value = "paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Resource(name = "paymentDAO")
    private PaymentDAO dao;

    public void addPayment(Payment payment) {
        // debit money logic
        dao.savePayment(payment);
    }

    public Set<Payment> getPayments() {
        return dao.getPayments();
    }

    public Payment get(long id) {
        return dao.get(id);
    }
}
