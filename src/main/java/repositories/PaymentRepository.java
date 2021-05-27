package repositories;

import model.Payment;

import java.util.Map;

public class PaymentRepository {

    private Map<Integer, Payment> paymentList = null;

    public PaymentRepository(Map<Integer, Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public Map<Integer, Payment> getPaymentList() {
        return paymentList;
    }

    public Payment getPaymentById(int id) {
        return paymentList.get(id);
    }

}
