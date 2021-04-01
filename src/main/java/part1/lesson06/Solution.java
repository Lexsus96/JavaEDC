package part1.lesson06;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static BigInteger count(int start, int end) {
        BigInteger sum = BigInteger.ONE;
        for (int i = start + 1; i <= end; i++) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random gen = new Random();
        ExecutorService threadPool = Executors.newFixedThreadPool(8);
        List<Integer> list = Stream.generate(() -> gen.nextInt(50)).limit(10).distinct().sorted().collect(Collectors.toList());

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
            System.out.print(list.get(i)+ ": ");
            currentDigit = currentDigit.multiply(answer.get(i).get());
            System.out.println(currentDigit);
        }
        threadPool.shutdown();
    }
}
