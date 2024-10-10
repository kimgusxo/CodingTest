package org.code.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int cnt = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'a') {
                cnt++;
            }
        }

        line += line;
        int min = 1000;

        for(int i = 0; i < line.length() - cnt; i++) {
            String sub = line.substring(i, i+cnt);
            int swap = 0;

            for (int j = 0; j < sub.length(); j++) {
                if (sub.charAt(j) == 'b') {
                    swap++;
                }
            }

            if(min > swap) {
                min = swap;
            }
        }

        System.out.println(min);
    }
}
