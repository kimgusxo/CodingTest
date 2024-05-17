package org.example.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1204 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for(int i=1; i<=cnt; i++) {

            int[] arr = new int[1000];
            int problemNumber = Integer.parseInt(bf.readLine());

            StringTokenizer st = new StringTokenizer(bf.readLine());

            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                arr[num]++;
            }

            int max=0;
            int maxIndex=0;

            for(int j=0; j<arr.length; j++) {
                if(arr[j] >= max) {
                    max = arr[j];
                    maxIndex = j;
                }
            }

            System.out.println("#"+problemNumber+" "+maxIndex);

        }
    }

}
