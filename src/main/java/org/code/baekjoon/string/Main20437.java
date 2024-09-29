package org.code.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int repeat = Integer.parseInt(br.readLine());

        String[] alphabet = new String[26];

        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = "";
        }

        for (int i = 0; i < repeat; i++) {
            String str = br.readLine();
            int cnt = Integer.parseInt(br.readLine());

            for(int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);

                if(alphabet[ch-'a'].equals("")) {
                    int index = str.indexOf(ch);
                    while(index != -1) {
                        alphabet[ch-'a'] += index;
                        index = str.indexOf(ch, index+1);
                    }
                }
            }

            for (int j = 0; j < alphabet.length; j++) {
                System.out.print(alphabet[j] + " ");
            }
        }
    }
}
