package com.percyvega.experiments.concurrency;

import com.percyvega.experiments.concurrency.util.ConcurrencyUtil;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.percyvega.experiments.concurrency.util.ConcurrencyUtil.NUMBER_OF_TASKS;

@Log4j2
public class CompletableFutureTest {

    @Test
    void sumCompletableFutureResultsOnceAllAreObtained() {
        List<CompletableFuture<Integer>> completableFutures = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            completableFutures.add(CompletableFuture.supplyAsync(ConcurrencyUtil::performLongTaskAndReturnRandomInt));
        }
        log.info("All {} tasks have been put in the queue.", NUMBER_OF_TASKS);

        // block until all completableFutures finish their task
        int sum = completableFutures.stream()
                .map(CompletableFuture::join)
                .mapToInt(i -> i)
                .sum();

        log.info("Finished obtaining return values from completableFutures. Their sum is {}.", sum);
    }

    @Test
    void combineCompletableFuturesIntoOne() throws InterruptedException {
        List<CompletableFuture<Integer>> completableFutures = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            completableFutures.add(CompletableFuture.supplyAsync(ConcurrencyUtil::performLongTaskAndReturnRandomInt));
        }
        log.info("All {} tasks have been put in the queue.", NUMBER_OF_TASKS);

        CompletableFuture<List<Integer>> combinedFuture = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]))
                .thenApply(v -> completableFutures.stream()
                        .map(CompletableFuture::join)
                        .toList()
                );
        log.info("Finished combining completableFutures.");

        combinedFuture.thenAccept(v -> {
            log.info("Finished obtaining return values from completableFutures. Their sum is {}.",
                    v.stream().mapToInt(i -> i).sum());
        }).join();
    }
}
