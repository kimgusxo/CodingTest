package org.code.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1984 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bf.readLine());

        for(int i=1; i<=count; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int el = Integer.parseInt(st.nextToken());

            int max = el;
            int min = el;
            int sum = el;

            for(int j=1; j<10; j++) {

                el = Integer.parseInt(st.nextToken());

                if(el > max) max = el;
                if(el < min) min = el;

                sum += el;
            }

            sum = sum-max-min;

            int result = Math.round((float)sum/8);

            System.out.println("#"+i+" "+result);
        }

    }
}
