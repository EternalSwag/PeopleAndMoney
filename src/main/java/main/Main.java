package main;

import config.Constants;
import enums.RankingType;
import model.Payment;
import model.Person;
import service.comparators.PersonComparatorReceivedMoney;
import service.comparators.PersonComparatorSentMoney;
import repositories.PaymentRepository;
import repositories.PeopleRepository;
import service.FileCSVLoader;
import service.FileCSVWriter;
import service.ProcessPeople;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        execute();
    }

    public static void execute() throws Exception {
        FileCSVLoader f = new FileCSVLoader();
        Map<Integer, Person> resultPeopleList = f.getPersonListFromFile(Constants.PEOPLE_LIST_FILE_LOCATION, 1);
        Map<Integer, Payment> resultPaymentList = f.getPaymentListFromFile(Constants.PAYMENT_LIST_FILE_LOCATION, 1);

        PeopleRepository peopleRepository = new PeopleRepository(resultPeopleList);
        PaymentRepository paymentRepository = new PaymentRepository(resultPaymentList);

        //calculate who sent and received most (fill field values of People objects how much they sent and received)
        ProcessPeople.calculateSentReceivedMoney(peopleRepository, paymentRepository);

        //convert map to list
        List<Person> examplePeopleList = peopleRepository.getPeopleAsList();

        //sort people list who sent most, and write to file
        PersonComparatorSentMoney personComparatorSent = new PersonComparatorSentMoney();
        Collections.sort(examplePeopleList, personComparatorSent);
        FileCSVWriter.writeToFileSortedPeople(examplePeopleList, RankingType.SENT_MONEY, Constants.OUTPUT_FILE_SENT_MONEY);

        //sort people list who received most and write to file
        PersonComparatorReceivedMoney personComparatorReceived = new PersonComparatorReceivedMoney();
        Collections.sort(examplePeopleList, personComparatorReceived);
        FileCSVWriter.writeToFileSortedPeople(examplePeopleList, RankingType.RECEIVED_MONEY, Constants.OUTPUT_FILE_RECEIVED_MONEY);
    }

}
