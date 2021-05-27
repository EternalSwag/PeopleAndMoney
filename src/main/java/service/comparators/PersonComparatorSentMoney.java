package service.comparators;

import model.Person;

import java.util.Comparator;

public class PersonComparatorSentMoney implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int thisSentMoney = o1.getSentMoney().intValue();
        int hisSentMoney = o2.getSentMoney().intValue();
        return Integer.compare(hisSentMoney, thisSentMoney);
    }
}