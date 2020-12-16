package com.percyvega.experiments.performance;

import java.util.Comparator;

public class SavingsAmountInCentsComparator implements Comparator<DbRecord> {

    @Override
    public int compare(DbRecord o1, DbRecord o2) {
//        return o2.getSavingsAmountInCents() - o1.getSavingsAmountInCents();
        return Integer.compare(o2.getSavingsAmountInCents(), o1.getSavingsAmountInCents());
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

}
