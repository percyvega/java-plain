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

    private static int RECORD_COUNT = 40_000;
    private static int SIZE_RANDOM_TEXT = 1024 * 4;

    private static NumberFormat NUMBER_FORMAT = new DecimalFormat("##.##");

    public static void main(String[] args) {
        useArray(false);
        useArray(true);

        useArrayList(false);
        useArrayList(true);
    }

    private static void useArray(boolean useJdkSort) {
        logger.debug("<<<<<<<<<< Starting useArray(useJdkSort=" + useJdkSort + ")");

        long startMillis;

        startMillis = System.currentTimeMillis();
        DbRecord[] dbRecords = getDbRecordsArray(RECORD_COUNT);
        logger.debug(NUMBER_FORMAT.format((System.currentTimeMillis() - startMillis) / 1000.0) + " seconds to generated data");
        startMillis = System.currentTimeMillis();
        sort(dbRecords, useJdkSort);
        logger.debug(NUMBER_FORMAT.format((System.currentTimeMillis() - startMillis) / 1000.0) + " seconds to sort data");

        logger.debug("Min savings amount: $" + NUMBER_FORMAT.format(dbRecords[0].getSavingsAmountInCents() / 100.0));
        logger.debug("Max savings amount: $" + NUMBER_FORMAT.format(dbRecords[dbRecords.length - 1].getSavingsAmountInCents() / 100.0));

        logger.debug(">>>>>>>>>> Finishing useArray(useJdkSort=" + useJdkSort + ")");
    }

    private static void useArrayList(boolean useJdkSort) {
        logger.debug("<<<<<<<<<< Starting useArrayList(useJdkSort=" + useJdkSort + ")");

        long startMillis;

        startMillis = System.currentTimeMillis();
        ArrayList<DbRecord> dbRecords = getDbRecordsArrayList(RECORD_COUNT);
        logger.debug(NUMBER_FORMAT.format((System.currentTimeMillis() - startMillis) / 1000.0) + " seconds to generated data");
        startMillis = System.currentTimeMillis();
        sort(dbRecords, useJdkSort);
        logger.debug(NUMBER_FORMAT.format((System.currentTimeMillis() - startMillis) / 1000.0) + " seconds to sort data");

        logger.debug("Min savings amount: $" + NUMBER_FORMAT.format(dbRecords.get(0).getSavingsAmountInCents() / 100.0));
        logger.debug("Max savings amount: $" + NUMBER_FORMAT.format(dbRecords.get(dbRecords.size() - 1).getSavingsAmountInCents() / 100.0));

        logger.debug(">>>>>>>>>> Finishing useArrayList(useJdkSort=" + useJdkSort + ")");
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

    private static void sort(DbRecord[] dbRecords, boolean useJdkSort) {
        if (useJdkSort) {
            Arrays.sort(dbRecords, Comparator.comparingInt(DbRecord::getSavingsAmountInCents));
        } else {
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
    }

    private static void sort(ArrayList<DbRecord> dbRecords, boolean useJdkSort) {
        if (useJdkSort) {
            Collections.sort(dbRecords, Comparator.comparingInt(DbRecord::getSavingsAmountInCents));
        } else {
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
}
