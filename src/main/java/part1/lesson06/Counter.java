package part1.lesson06;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Counter {
    private int N_THREADS = 8;
    private Map<Integer, BigInteger> hashMap = new HashMap<>();

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
    
    public static <T> CompletableFuture<List<T>> allOf(
            Collection<CompletableFuture<T>> futures) {
        return futures.stream()
                .collect(collectingAndThen(
                        toList(),
                        l -> CompletableFuture.allOf(l.toArray(new CompletableFuture[0]))
                                .thenApply(__ -> l.stream()
                                        .map(CompletableFuture::join)
                                        .collect(Collectors.toList()))));
    }

    public Map<Integer, BigInteger> execute(List<Integer> list) throws ExecutionException, InterruptedException {
        Map<Integer, BigInteger> map = new HashMap<>();

        list = list.stream().distinct().sorted().collect(toList());
        list.stream().filter(i -> hashMap.containsKey(i)).forEach(i -> map.put(i, hashMap.get(i)));
        list = list.stream().filter(i -> !hashMap.containsKey(i)).collect(toList());
        ExecutorService threadPool = Executors.newFixedThreadPool(N_THREADS);
        List<CompletableFuture<BigInteger>> answer = new ArrayList<>();
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
        List<BigInteger> l = allOf(answer).join();
        BigInteger currentDigit = BigInteger.ONE;
        for (int i = 0; i < answer.size(); i++) {
            currentDigit = currentDigit.multiply(l.get(i));
            map.put(list.get(i), currentDigit);
            hashMap.putIfAbsent(list.get(i), currentDigit);
        }

        threadPool.shutdown();
        return map;
    }
}
