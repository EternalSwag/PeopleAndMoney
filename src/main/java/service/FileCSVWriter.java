package service;

import enums.RankingType;
import model.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileCSVWriter {

    /**
     * writes sorted list to file
     * @param list
     * @param type
     * @param filename
     * @throws Exception
     */
    public static void writeToFileSortedPeople(List<Person> list, RankingType type, String filename) throws Exception {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(filename);
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            System.out.println("Problem creating file " + filename);
        }

        if (bufferedWriter == null) {
            throw new Exception("Error occured trying to write to file, failed to initiate buffer: " + filename);
        }

        for (Person p : list) {
            writeToBuffer(bufferedWriter, p.getName());
            writeToBuffer(bufferedWriter, " ");
            writeToBuffer(bufferedWriter, p.getSurname());
            writeToBuffer(bufferedWriter, " ");

            switch (type) {
                case RECEIVED_MONEY:
                    writeToBuffer(bufferedWriter, p.getReceivedMoney());
                    break;
                case SENT_MONEY:
                    writeToBuffer(bufferedWriter, p.getSentMoney());
                    break;
                default:
                    throw new Exception("Uncategorized ranking type provided during writing file");
            }

            writeToBuffer(bufferedWriter, "\n");
        }
        bufferedWriter.close();
    }

    /**
     * write anything to buffer
     * @param bufferedWriter
     * @param s
     * @param <T>
     * @throws IOException
     */
    private static <T> void writeToBuffer(BufferedWriter bufferedWriter, T s) throws IOException {
        try {
            bufferedWriter.write(s.toString());
        } catch (IOException e) {
            System.out.println("Error occured trying to write: " + s.toString());
        }
    }

}
