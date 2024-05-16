package org.example.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1959 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for(int i=1; i<=cnt; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int length1 = Integer.parseInt(st.nextToken());
            int length2 = Integer.parseInt(st.nextToken());

            int[] first = new int[length1];
            int[] second = new int[length2];

            StringTokenizer firstTokens = new StringTokenizer(bf.readLine());
            StringTokenizer secondTokens = new StringTokenizer(bf.readLine());

            for(int j=0; j<length1; j++) {
                first[j] = Integer.parseInt(firstTokens.nextToken());
            }

            for(int j=0; j<length2; j++) {
                second[j] = Integer.parseInt(secondTokens.nextToken());
            }

            int[] bigger = length1<=length2?second:first;
            int[] smaller = length1<=length2?first:second;

            int max = 0;

            for(int j=0; j<=bigger.length-smaller.length; j++) {
                int sum = 0;
                for(int k=j; k<j+smaller.length; k++) {
                    sum += (bigger[k]*smaller[k-j]);
                }

                if(sum > max) {
                    max = sum;
                }
            }

            System.out.println("#"+i+" "+max);

        }
    }
}
