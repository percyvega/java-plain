package com.percyvega.experiments.performance;

import org.fluttercode.datafactory.impl.DataFactory;

import java.util.ArrayList;

public interface DataPerformance {

    int SIZE_RANDOM_TEXT = 1024 * 4;

    static DbRecord[] getDbRecordsArray(int recordCount) {
        DbRecord[] dbRecords = new DbRecord[recordCount];

        DataFactory df = new DataFactory();
        for (int i = 0; i < recordCount; i++) {
            dbRecords[i] = getDbRecord(df);
        }
        return dbRecords;
    }

    static ArrayList<DbRecord> getDbRecordsArrayList(int recordCount) {
        ArrayList<DbRecord> dbRecords = new ArrayList<>(recordCount);

        DataFactory df = new DataFactory();
        for (int i = 0; i < recordCount; i++) {
            dbRecords.add(getDbRecord(df));
        }
        return dbRecords;
    }

    static DbRecord getDbRecord(DataFactory df) {
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

}
