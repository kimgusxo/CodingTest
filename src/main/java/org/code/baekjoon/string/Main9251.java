package org.code.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main9251 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String wordFirst = br.readLine();
        String wordSecond = br.readLine();

        int[][] dp = new int[wordFirst.length()+1][wordSecond.length()+1];

        PriorityQueue<Integer> resultQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(wordFirst.charAt(i-1) == wordSecond.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                resultQueue.add(dp[i][j]);
            }
        }

        System.out.println(resultQueue.remove());
    }
}
