package part1.lesson01.task02;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NRandoms {
    private List<Integer> list;

    public NRandoms(int n) {
        list = new ArrayList<Integer>(n);
        Date date = new Date();
        Random random = new Random(date.getTime());
        IntStream intStream = random.ints(-1, Integer.MAX_VALUE);
        list = intStream.limit(n).boxed().collect(Collectors.toList());
    }

    public void printSquares() throws NegativeException {
        for(Integer tmp: list) {
                if (tmp < 0) {
                    throw new NegativeException(tmp + " less than 0");
                }
                if (compareIntIsSquare(tmp)) {
                    System.out.print(tmp + " ");
                }
        }
    }
    private boolean compareIntIsSquare(int a) {
        int tmp = (int) Math.sqrt(a);
        return tmp * tmp == a;
    }
}
