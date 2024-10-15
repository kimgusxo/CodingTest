package org.code.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12865 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        int bag = Integer.parseInt(st.nextToken());

        int[][] arr = new int[cnt+1][2];

        for (int i = 1; i <= cnt; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[bag+1];

        recursion(arr, dp, bag);
    }

    public static void recursion(int[][] arr, int[] dp, int bag) {

    }

}
