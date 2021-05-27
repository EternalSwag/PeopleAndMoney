package service.comparators;


import model.Person;

import java.util.Comparator;

public class PersonComparatorReceivedMoney implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int thisReceived = o1.getReceivedMoney().intValue();
        int hisReceivedMoney = o2.getReceivedMoney().intValue();
        return Integer.compare(hisReceivedMoney, thisReceived);
    }
}