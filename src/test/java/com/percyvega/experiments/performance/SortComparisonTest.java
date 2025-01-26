package com.percyvega.experiments.performance;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import static com.percyvega.experiments.performance.DataPerformance.getDbRecordsArray;
import static com.percyvega.experiments.performance.DataPerformance.getDbRecordsArrayList;

@Log4j2
public class SortComparisonTest {

    private static final int RECORD_COUNT = (int) Math.pow(2.0, 14.0);

    private static DbRecord[] dbArray1, dbArray2;
    private static ArrayList<DbRecord> dbArrayList1, dbArrayList2;

    @BeforeAll
    static void beforeAll() {
        dbArray1 = getDbRecordsArray(RECORD_COUNT);
        dbArray2 = getDbRecordsArray(RECORD_COUNT);
        dbArrayList1 = getDbRecordsArrayList(RECORD_COUNT);
        dbArrayList2 = getDbRecordsArrayList(RECORD_COUNT);
    }

    @Test
    void quickSortArray() {
//        Arrays.sort(dbArray1, new SavingsAmountInCentsComparator());
        Arrays.stream(dbArray1)
                .sorted(new SavingsAmountInCentsComparator())
                .collect(Collectors.toList());
    }

    @Test
    void bubbleSortArray() {
        bubbleSort(dbArray2);
    }

    @Test
    void quickSortArrayList() {
//        Collections.sort(dbArrayList1, new SavingsAmountInCentsComparator());
//        dbArrayList1.sort(new SavingsAmountInCentsComparator());
//        dbArrayList1.sort(Comparator.comparingInt(DbRecord::getSavingsAmountInCents));
        dbArrayList1.sort(Comparator.comparing(DbRecord::getSavingsAmountInCents));
    }

    @Test
    void bubbleSortArrayList() {
        bubbleSort(dbArrayList2);
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
