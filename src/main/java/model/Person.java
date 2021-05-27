package model;

import java.math.BigDecimal;

public class Person implements Comparable{

    private int id;
    private String name;
    private String surname;

    private BigDecimal receivedMoney = new BigDecimal(0);
    private BigDecimal sentMoney = new BigDecimal(0);

    public Person(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }


    public void receiveMoney(BigDecimal amount) {
        this.receivedMoney = this.receivedMoney.add(amount);
    }

    public void sendMoney(BigDecimal amount) {
        this.sentMoney = this.sentMoney.add(amount);
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public BigDecimal getReceivedMoney() {
        return receivedMoney;
    }

    public void setReceivedMoney(BigDecimal receivedMoney) {
        this.receivedMoney = receivedMoney;
    }

    public BigDecimal getSentMoney() {
        return sentMoney;
    }

    public void setSentMoney(BigDecimal sentMoney) {
        this.sentMoney = sentMoney;
    }


    @Override
    public int compareTo(Object o) {
        int thisReceived = this.getReceivedMoney().intValue();
        Person him = (Person) o;
        int hisReceivedMoney = him.getReceivedMoney().intValue();
        return thisReceived - hisReceivedMoney;
    }

}

