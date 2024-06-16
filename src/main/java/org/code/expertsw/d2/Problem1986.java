package org.code.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1986 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bf.readLine());

        for(int i=1; i<=count; i++) {
            int result = 0;
            int num = Integer.parseInt(bf.readLine());

            int sum = (num/2)*-1;

            if(num%2 == 0) {
                result = sum;
            } else {
                result = sum+num;
            }

            System.out.println("#"+i+" "+result);
        }
    }
}
