package service;

import config.Constants;
import model.Payment;
import model.Person;

import java.math.BigDecimal;

public class CSVProcessor {

    public Payment makePaymentFromCSVLine(String line) throws Exception {
        String[] separatedWords = processCSVLine(line, Constants.CSV_SEPARATING_SYMBOL);
        if (separatedWords.length != 4) {
            throw new Exception("Payment list has invalid entry, line " + line);
        }

        int transactionId = 0;
        BigDecimal sum = null;
        int toId = 0;
        int fromId = 0;
        try {
            transactionId = Integer.valueOf(separatedWords[0]);
            sum = new BigDecimal(separatedWords[1]);
            toId = Integer.valueOf(separatedWords[2]);
            fromId = Integer.valueOf(separatedWords[3]);
        } catch (NumberFormatException e) {
            System.out.println("Format error processing line: " + line);
        }

        return new Payment(transactionId, sum, toId, fromId);
    }

    public Person makePersonFromCSVLine(String line) throws Exception {
        String[] separatedWords = processCSVLine(line, Constants.CSV_SEPARATING_SYMBOL);
        if (separatedWords.length != 3) {
           throw new Exception("Person list has invalid entry, line " + line);
        }
        return new Person(Integer.valueOf(separatedWords[0]), separatedWords[1], separatedWords[2]);
    }

    private String[] processCSVLine(String line, String separatorSymbol) {
        line = initialCSVLineProcess(line);
        String[] separatedWords = splitterLineCSV(line, separatorSymbol);
        return separatedWords;
    }

    /**
     * trim, remove spaces
     *
     * @return
     */
    private String initialCSVLineProcess(String rawCSVLine) {
        String result = rawCSVLine.trim();
        result = result.replaceAll("\\s+", "");
        return result;
    }

    /**
     * split line by separating symbol, ex ","
     *
     * @param line
     * @param separatorSymbol
     * @return
     */
    private String[] splitterLineCSV(String line, String separatorSymbol) {
        String[] result = line.split(separatorSymbol);
        return result;
    }

}
