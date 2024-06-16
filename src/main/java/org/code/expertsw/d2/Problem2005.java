package org.code.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2005 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bf.readLine());

        for(int i=1; i<=count; i++) {
            StringBuilder sb = new StringBuilder();
            int floor = Integer.parseInt(bf.readLine());

            int[][] arr = new int[floor][floor];
            arr[0][0] = 1;
            sb.append(arr[0][0]);
            sb.append("\n");

            for(int j=1; j<floor; j++) {
                arr[j][0] = 1;
                sb.append(arr[j][0]);
                sb.append(" ");
                for(int k=1; k<=j; k++) {
                    arr[j][k] = arr[j-1][k-1]+arr[j-1][k];
                    sb.append(arr[j][k]);
                    sb.append(" ");
                }
                sb.append("\n");
            }

            System.out.print("#"+i);
            System.out.println(sb);
        }

    }
}
