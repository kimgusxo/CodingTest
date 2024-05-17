package org.example.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1288 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for(int i=1; i<=cnt; i++) {
            int num = Integer.parseInt(bf.readLine());
            String str = String.valueOf(num);
            String result = "";

            int repeat = 2;

            while(true) {
                for(int j=0; j<str.length(); j++) {
                    if(result.indexOf(str.charAt(j)) == -1) {
                        result += str.charAt(j);
                    }
                }

                if(result.length()==10) break;

                int n = num*repeat;
                str = String.valueOf(n);
                repeat++;
            }

            System.out.println("#"+i+" "+str);

        }

    }
}
