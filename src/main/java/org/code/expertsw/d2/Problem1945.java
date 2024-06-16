package org.code.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem1945 {

    static int[] factorization = {2, 3, 5, 7, 11};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for(int i=1; i<=cnt; i++) {
            int num = Integer.parseInt(bf.readLine());
            ArrayList<Integer> arr = new ArrayList<>();

            for(int a : factorization) {
                int repeat = 0;
                while(true) {
                    if(num%a==0) {
                        num /= a;
                        repeat++;
                    } else {
                        break;
                    }
                }
                arr.add(repeat);
            }

            System.out.print("#"+i+" ");
            arr.stream().forEach((r) -> System.out.print(r+ " "));
            System.out.println();
        }

    }
}
