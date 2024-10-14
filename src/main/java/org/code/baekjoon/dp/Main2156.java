package org.code.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2156 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        int[] arr = new int[cnt+1];
        int[] dp = new int[cnt+1];

        for(int i = 1; i <= cnt; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(cnt == 1) {
            System.out.println(arr[1]);
        } else if(cnt == 2) {
            System.out.println(arr[1] + arr[2]);
        } else if (cnt >= 3) {
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];

            for (int i = 3; i <= cnt; i++) {
                int one = dp[i-2] + arr[i];
                int two = dp[i-1];
                int three = dp[i-3] + arr[i] + arr[i-1];

                dp[i] = max(one, two, three);
            }
            System.out.println(dp[cnt]);
        }
    }

    public static int max(int a, int b, int c) {
        int max = a;

        if(b > max) {
            max = b;
        }
        if(c > max) {
            max = c;
        }

        return max;
    }
}
