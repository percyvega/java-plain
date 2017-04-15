package com.percyvega.experiments.performance;

import org.fluttercode.datafactory.impl.DataFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    private static int RECORD_COUNT = (int) Math.pow(2.0, 15.0);
    private static int SIZE_RANDOM_TEXT = 1024 * 4;

    private static NumberFormat NUMBER_FORMAT = new DecimalFormat("##.##");

    public static void main(String[] args) {
        logger.debug("RECORD_COUNT: " + RECORD_COUNT);
        logger.debug("SIZE_RANDOM_TEXT: " + SIZE_RANDOM_TEXT);
        System.out.println();
        useArray(true);
        System.out.println();
        useArrayList(true);
        System.out.println();
        useArray(false);
        System.out.println();
        useArrayList(false);
    }

    private static void useArray(boolean useMergeSort) {
        logger.debug("<<<<<<<<<< Starting useArray(useMergeSort=" + useMergeSort + ")");

        long startMillis = System.currentTimeMillis();
        DbRecord[] dbRecords = getDbRecordsArray(RECORD_COUNT);
        logger.debug(NUMBER_FORMAT.format((System.currentTimeMillis() - startMillis) / 1000.0) + " seconds to generated data");

        startMillis = System.currentTimeMillis();
        if(useMergeSort)
            mergeSort(dbRecords);
        else
            bubbleSort(dbRecords);
        logger.debug(NUMBER_FORMAT.format((System.currentTimeMillis() - startMillis) / 1000.0) + " seconds to sort data");

        logger.debug("Min savings amount: $" + NUMBER_FORMAT.format(dbRecords[0].getSavingsAmountInCents() / 100.0) + " - " + dbRecords[0]);
        logger.debug("Max savings amount: $" + NUMBER_FORMAT.format(dbRecords[dbRecords.length - 1].getSavingsAmountInCents() / 100.0) + " - " + dbRecords[dbRecords.length - 1]);

        logger.debug(">>>>>>>>>> Finishing useArray(useMergeSort=" + useMergeSort + ")");
    }

    private static void useArrayList(boolean useMergeSort) {
        logger.debug("<<<<<<<<<< Starting useArrayList(useMergeSort=" + useMergeSort + ")");

        long startMillis = System.currentTimeMillis();
        ArrayList<DbRecord> dbRecords = getDbRecordsArrayList(RECORD_COUNT);
        logger.debug(NUMBER_FORMAT.format((System.currentTimeMillis() - startMillis) / 1000.0) + " seconds to generated data");

        startMillis = System.currentTimeMillis();
        if(useMergeSort)
            mergeSort(dbRecords);
        else
            bubbleSort(dbRecords);
        logger.debug(NUMBER_FORMAT.format((System.currentTimeMillis() - startMillis) / 1000.0) + " seconds to sort data");

        logger.debug("Min savings amount: $" + NUMBER_FORMAT.format(dbRecords.get(0).getSavingsAmountInCents() / 100.0) + " - " + dbRecords.get(0));
        logger.debug("Max savings amount: $" + NUMBER_FORMAT.format(dbRecords.get(dbRecords.size() - 1).getSavingsAmountInCents() / 100.0) + " - " + dbRecords.get(dbRecords.size() - 1));

        logger.debug(">>>>>>>>>> Finishing useArrayList(useMergeSort=" + useMergeSort + ")");
    }

    private static DbRecord[] getDbRecordsArray(int recordCount) {
        DbRecord[] dbRecords = new DbRecord[recordCount];

        DataFactory df = new DataFactory();
        for (int i = 0; i < recordCount; i++) {
            dbRecords[i] = getDbRecord(df);
        }
        return dbRecords;
    }

    private static ArrayList<DbRecord> getDbRecordsArrayList(int recordCount) {
        ArrayList<DbRecord> dbRecords = new ArrayList<>(recordCount);

        DataFactory df = new DataFactory();
        for (int i = 0; i < recordCount; i++) {
            dbRecords.add(getDbRecord(df));
        }
        return dbRecords;
    }

    private static DbRecord getDbRecord(DataFactory df) {
        DbRecord dbRecord = new DbRecord();
        dbRecord.setAvailable(df.chance(50));
        dbRecord.setAddress(df.getAddress());
        dbRecord.setAddressLine2(df.getAddressLine2());
        dbRecord.setBirthDate(df.getBirthDate());
        dbRecord.setBusinessName(df.getBusinessName());
        dbRecord.setCity(df.getCity());
        dbRecord.setEmailAddress(df.getEmailAddress());
        dbRecord.setFirstName(df.getFirstName());
        dbRecord.setLastName(df.getLastName());
        dbRecord.setSavingsAmountInCents(df.getNumberBetween(1, Integer.MAX_VALUE));
        dbRecord.setPassword(df.getRandomWord() + df.getNumberText(4));
        dbRecord.setNote(df.getRandomText(SIZE_RANDOM_TEXT));

        return dbRecord;
    }

    private static void mergeSort(DbRecord[] dbRecords) {
        Arrays.sort(dbRecords, Comparator.comparingInt(DbRecord::getSavingsAmountInCents));
    }

    private static void mergeSort(ArrayList<DbRecord> dbRecords) {
        Collections.sort(dbRecords, Comparator.comparingInt(DbRecord::getSavingsAmountInCents));
    }

    private static void bubbleSort(DbRecord[] dbRecords) {
        for (int i = 0; i < dbRecords.length; i++) {
            for (int j = i + 1; j < dbRecords.length; j++) {
                if (dbRecords[i].getSavingsAmountInCents() > dbRecords[j].getSavingsAmountInCents()) {
                    DbRecord temp = dbRecords[i];
                    dbRecords[i] = dbRecords[j];
                    dbRecords[j] = temp;
                }
            }
        }
    }

    private static void bubbleSort(ArrayList<DbRecord> dbRecords) {
        for (int i = 0; i < dbRecords.size(); i++) {
            for (int j = i + 1; j < dbRecords.size(); j++) {
                if (dbRecords.get(i).getSavingsAmountInCents() > dbRecords.get(j).getSavingsAmountInCents()) {
                    DbRecord temp = dbRecords.get(i);
                    dbRecords.set(i, dbRecords.get(j));
                    dbRecords.set(j, temp);
                }
            }
        }
    }

}
