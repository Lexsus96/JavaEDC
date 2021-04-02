package part1.lesson06;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static List<Integer> generateList(int max_n, int size) {
        Random gen = new Random();
        return Stream.generate(() -> gen.nextInt(max_n)).limit(size).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Integer> list = generateList(1000, 100);
        Counter counter = new Counter();
        try {
            Map<Integer, BigInteger> map = counter.execute(list);
            System.out.println(map);
            list = generateList(50, 100);
            map = counter.execute(list);
            System.out.println(map);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
