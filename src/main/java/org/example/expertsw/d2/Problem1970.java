package org.example.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1970 {

    static final int[] charger = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for(int i=1; i<=cnt; i++) {
            int price = Integer.parseInt(bf.readLine());

            int[] charge = new int[8];

            for (int j=0; j<charge.length; j++) {
                int count = price/charger[j];
                charge[j] = count;
                price = price%charger[j];
            }

            System.out.println("#"+i);
            for(int count : charge) {
                System.out.print( count+" ");
            }
            System.out.println();
        }
    }
}