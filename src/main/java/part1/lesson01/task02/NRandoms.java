package part1.lesson01.task02;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class NRandoms {
    private List<Integer> list;

    public NRandoms(int n) {
        list = new ArrayList<Integer>(n);
        Date date = new Date();
        Random random = new Random(date.getTime());
        for (int i = 0; i < n; i++) {
            int negative_flag = 1;
            if (random.nextInt(2) == 0) {
                negative_flag = -1;
            }
            list.add(negative_flag * random.nextInt(Integer.MAX_VALUE));
        }
    }

    public void printSquares() {
        for(Integer tmp: list) {
            try {
                if (tmp < 0) {
                    throw new NegativeException(tmp + " less than 0");
                }
                if (Double.compare(tmp, Math.pow(Math.floor(Math.sqrt(tmp)), 2)) == 0) {
                    System.out.print(tmp + " ");
                }
            } catch (NegativeException e) {
                //System.out.println(e.getMessage());
            }
        }
    }
}
