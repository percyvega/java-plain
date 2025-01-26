package com.percyvega.experiments.print;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class PrintOverSameLine {

    public static void main(String[] args) throws InterruptedException {
        long total = 235;
        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= total; i = i + 3) {
            Thread.sleep(50);
            printProgress(startTime, total, i);
        }
    }

    private static void printProgress(long startTime, long total, long current) {
        long eta = current == 0 ? 0 :
                (total - current) * (System.currentTimeMillis() - startTime) / current;

        String etaHms = current == 0 ? "N/A" :
                String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(eta),
                        TimeUnit.MILLISECONDS.toMinutes(eta) % TimeUnit.HOURS.toMinutes(1),
                        TimeUnit.MILLISECONDS.toSeconds(eta) % TimeUnit.MINUTES.toSeconds(1));

        int percent = (int) (current * 100 / total);
        String string = '\r' +
                String.join("", Collections.nCopies(percent == 0 ? 2 : 2 - (int) (Math.log10(percent)), " ")) +
                String.format(" %d%% [", percent) +
                String.join("", Collections.nCopies(percent, "=")) +
                '>' +
                String.join("", Collections.nCopies(100 - percent, " ")) +
                ']' +
                String.join("", Collections.nCopies((int) (Math.log10(total)) - (int) (Math.log10(current)), " ")) +
                String.format(" %d/%d, ETA: %s", current, total, etaHms);

        System.out.print(string);
    }

}
