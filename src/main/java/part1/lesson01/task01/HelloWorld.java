package part1.lesson01.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
    public static void throwNullPointerException() throws NullPointerException {
        String s = null;
        System.out.println(s.length());
    }
    public static void throwArrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException {
        int[] arr = new int[1];
        System.out.println(arr[1]);
    }
    public static void throwIOException() throws IOException {
        throw  new IOException();
    }
}
