package org.code.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1989 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bf.readLine());

        for(int i=1; i<=count; i++) {
            String word = bf.readLine();

            int length = word.length();
            int flag = 0;

            if(length%2 != 0) {
                StringBuffer sb = new StringBuffer(word.substring(length/2+1, length));
                if(word.substring(0, (length/2)).equals(sb.reverse().toString())) {
                    flag = 1;
                }
            } else {
                StringBuffer sb = new StringBuffer(word.substring(length/2+1, length));
                if(word.substring(0, (length/2-1)).equals(sb.reverse().toString())) {
                    flag = 1;
                }
            }

            System.out.println("#"+i+" "+flag);
        }
    }
}
