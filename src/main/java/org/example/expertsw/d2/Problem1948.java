package org.example.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1948 {

    static int[] calendar = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for(int i=1; i<=cnt; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int firstMonth = Integer.parseInt(st.nextToken());
            int firstDay = Integer.parseInt(st.nextToken());
            int secondMonth = Integer.parseInt(st.nextToken());
            int secondDay = Integer.parseInt(st.nextToken());

            int result = 0;

            if(firstMonth==secondMonth) {
                result = (secondDay-firstDay)+1;
            }
            else if((secondMonth-firstMonth)==1) {
                result += calendar[firstMonth]-firstDay;
                result += secondDay;
                result += 1;
            }
            else {
                result += calendar[firstMonth]-firstDay;
                result += secondDay;
                for(int j=firstMonth+1; j<secondMonth; j++) {
                    result += calendar[j];
                }
                result += 1;
            }

            System.out.println("#"+i+" "+result);
        }
    }
}
