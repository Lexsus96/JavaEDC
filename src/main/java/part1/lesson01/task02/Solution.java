package part1.lesson01.task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            NRandoms nRandoms = new NRandoms(n);
            nRandoms.printSquares();
        }
    }
}
