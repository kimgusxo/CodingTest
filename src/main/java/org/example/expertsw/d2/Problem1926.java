package org.example.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1926 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i=1; i<=num; i++) {
            String word = String.valueOf(i);
            String clap = "";

            for(int j=0; j<word.length(); j++) {
                char c = word.charAt(j);
                if(c == '3' || c == '6' || c == '9') {
                    clap += "-";
                }
            }

            if(clap.length() > 0) {
                word = clap;
            }

            sb.append(word);
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb);
    }
}
