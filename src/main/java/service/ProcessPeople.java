package service;

import model.Payment;
import model.Person;
import repositories.PaymentRepository;
import repositories.PeopleRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ProcessPeople {


    /**
     * calculate who sent money to whom, and how much
     * @param peopleRepository
     * @param paymentRepository
     */
    public static void calculateSentReceivedMoney(PeopleRepository peopleRepository, PaymentRepository paymentRepository)
    {
        var personList = peopleRepository.getPersonList();
        var paymentList = paymentRepository.getPaymentList();

        Iterator it = paymentList.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());

            Payment currentTransaction = (Payment) pair.getValue();
            Person whoReceivesMoney = peopleRepository.getPersonById(currentTransaction.getToId());
            Person whoSendsMoney = peopleRepository.getPersonById(currentTransaction.getFromId());

            whoReceivesMoney.receiveMoney(currentTransaction.getSum());
            whoSendsMoney.sendMoney(currentTransaction.getSum());

            System.out.println(whoSendsMoney.getName() + " sends $" + currentTransaction.getSum().toString() + " to " + whoReceivesMoney.getName());
            System.out.println(whoReceivesMoney.getName() + " now has $" + whoReceivesMoney.getReceivedMoney());
        }
    }


}
