package org.code.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        int[] arr = new int[cnt+1];
        int[] dp = new int[cnt+1];

        for(int i = 1; i <= cnt; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(cnt >= 1) {
            dp[1] = arr[1];
        }
        if(cnt >= 2) {
            dp[2] = arr[1] + arr[2];
        }
        if(cnt >= 3) {
            for(int i = 3; i <= cnt; i++) {
                dp[i] = Math.max(arr[i] + arr[i-1] + dp[i-3], arr[i] + dp[i-2]);
            }
        }
        System.out.println(dp[cnt]);
    }
}
