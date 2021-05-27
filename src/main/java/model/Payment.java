package model;

import java.math.BigDecimal;


public class Payment {
    private final int transactionId;
    private final BigDecimal sum;
    private final int toId;
    private final int fromId;

    public Payment(int transactionId, BigDecimal sum, int toId, int fromId) {
        this.transactionId = transactionId;
        this.sum = sum;
        this.toId = toId;
        this.fromId = fromId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public int getToId() {
        return toId;
    }

    public int getFromId() {
        return fromId;
    }
}
