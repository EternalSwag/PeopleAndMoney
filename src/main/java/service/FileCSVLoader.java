package service;

import model.Payment;
import model.Person;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileCSVLoader {

    public Map<Integer, Payment> getPaymentListFromFile(String fileName, int firstLinesToSkip) throws Exception {
        CSVProcessor csvProcessor = new CSVProcessor();
        Map<Integer, Payment> resultMap = new HashMap<>();

        File myFile = new File(fileName);
        FileInputStream fis = new FileInputStream(myFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        while ((line = br.readLine()) != null) {
            if (firstLinesToSkip <= 0) {
                Payment currentPayment = csvProcessor.makePaymentFromCSVLine(line);
                if (currentPayment != null) resultMap.put(currentPayment.getTransactionId(), currentPayment);
            }
            firstLinesToSkip--;
        }
        br.close();

        return resultMap;
    }


    public Map<Integer, Person> getPersonListFromFile(String fileName, int firstLinesToSkip) throws Exception {
        CSVProcessor csvProcessor = new CSVProcessor();
        Map<Integer, Person> resultMap = new HashMap<>();

        File myFile = new File(fileName);
        FileInputStream fis = new FileInputStream(myFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        while ((line = br.readLine()) != null) {
            if (firstLinesToSkip <= 0) {
                Person currentPerson = csvProcessor.makePersonFromCSVLine(line);
                if (currentPerson != null) resultMap.put(currentPerson.getId(), currentPerson);
            }
            firstLinesToSkip--;
        }
        br.close();

        return resultMap;
    }

}
