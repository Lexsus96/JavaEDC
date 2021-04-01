package part1.lesson06;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Counter {
    private int N_THREADS = 8;
    Counter() {

    }
    Counter(int N_THREADS) {
        this.N_THREADS = N_THREADS;
    }
    public BigInteger count(int start, int end) {
        BigInteger sum = BigInteger.ONE;
        for (int i = start + 1; i <= end; i++) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        return sum;
    }

    public Map<Integer, BigInteger> execute(List<Integer> list) throws ExecutionException, InterruptedException {
        Map<Integer, BigInteger> map = new HashMap<>();
        list = list.stream().distinct().sorted().collect(Collectors.toList());
        ExecutorService threadPool = Executors.newFixedThreadPool(N_THREADS);
        List<Future<BigInteger>> answer = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int start, end;
            if (i == 0) {
                start = 0;
            } else {
                start = list.get(i - 1);
            }
            end = list.get(i);
            answer.add(CompletableFuture.supplyAsync(() -> count(start, end), threadPool));
        }

        BigInteger currentDigit = BigInteger.ONE;
        for (int i = 0; i < answer.size(); i++) {
            currentDigit = currentDigit.multiply(answer.get(i).get());
            map.put(list.get(i), currentDigit);
        }

        threadPool.shutdown();
        return map;
    }
}
