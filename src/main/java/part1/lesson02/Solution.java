package part1.lesson02;

public class Solution {
    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 2, 3};
        Integer[] equalArr = new Integer[]{1, 2, 3};
        Long[] arr2 = new Long[]{1L, 2L, 3L};
        Double[] arr3 = new Double[]{1.0, 2.0, 3.0};

        MathBox<Integer> mathBox = new MathBox<>(arr);
        MathBox<Integer> equalMathBox = new MathBox<>(equalArr);
        MathBox<Long> mathBox2 = new MathBox<>(arr2);
        MathBox<Double> mathBox3 = new MathBox<>(arr3);

        mathBox.dump();
        mathBox2.dump();
        mathBox3.dump();

        System.out.println("Hash mathBox:" + mathBox.hashCode());
        System.out.println("Hash mathBox3:" + mathBox3.hashCode());
        System.out.println("Hash equalMathBox:" + equalMathBox.hashCode());
        System.out.println("mathBox.equals(equalMathBox): " + mathBox.equals(equalMathBox));

        mathBox3.addObject(5.0);
        mathBox.deleteObject(2);

        System.out.println("Sum mathBox: " + mathBox.summator());
        System.out.println("Sum mathBox2: " + mathBox2.summator());
        System.out.println("Sum mathBox3: " + mathBox3.summator());

        mathBox.splitter(2);
        mathBox2.splitter(2L);
        mathBox3.splitter(2.0);

        System.out.println("splitter mathBox:" + mathBox);
        System.out.println("splitter mathBox2: " + mathBox2);
        System.out.println("splitter mathBox3: " + mathBox3);

    }
}
