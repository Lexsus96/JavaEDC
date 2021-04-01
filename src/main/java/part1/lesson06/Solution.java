package part1.lesson06;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        Random gen = new Random();
        List<Integer> list = Stream.generate(() -> gen.nextInt(50)).limit(100).collect(Collectors.toList());
        Counter counter = new Counter();
        try {
            Map<Integer, BigInteger> map = counter.execute(list);
            System.out.println(map);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
