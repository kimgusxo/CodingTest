package org.code.expertsw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem20019 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for(int i=1; i<=cnt; i++) {
            String str = bf.readLine();
            int N = str.length();

            boolean flag = false;

            int count = 0;

            while(count < 2) {
                count++;
                if(N%2==0) {
                    String firstWord = str.substring(0, (N/2));
                    String secondWord = str.substring(N/2, N);
                    StringBuilder sb2 = new StringBuilder(secondWord);
                    sb2.reverse();
                    if(firstWord.equals(sb2.toString())) {
                        flag = true;
                        str = firstWord;
                        N = N/2;
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    String firstWord = str.substring(0, (N/2));
                    String secondWord = str.substring((N/2)+1, N);
                    StringBuilder sb2 = new StringBuilder(secondWord);
                    sb2.reverse();
                    if(firstWord.equals(sb2.toString())) {
                        flag = true;
                        str = firstWord;
                        N = N/2;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            String result = "";

            if(flag) {
                result = "YES";
            } else {
                result = "NO";
            }

            System.out.println("#"+i+" "+result);

        }
    }

}
