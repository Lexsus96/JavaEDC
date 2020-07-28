package part1.lesson01.task01;

import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        try {
            HelloWorld.throwNullPointerException();
        } catch (NullPointerException e) {
            System.out.println(e.getClass().getSimpleName());

        }
        try {
            HelloWorld.throwArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getClass().getSimpleName());
        }
        System.out.println("Hello, World!");
        HelloWorld.throwIOException();
    }
}
