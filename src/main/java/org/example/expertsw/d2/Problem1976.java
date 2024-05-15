package org.example.expertsw.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1976 {

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bf.readLine());

        for (int i=1; i<=count; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int firstHour = Integer.parseInt(st.nextToken());
            int firstMin = Integer.parseInt(st.nextToken());
            int secondHour = Integer.parseInt(st.nextToken());
            int secondMin = Integer.parseInt(st.nextToken());

            int totalHour = firstHour+secondHour;
            int totalMin = firstMin+secondMin;

            if(totalMin > 59) {
                totalMin -= 60;
                totalHour++;
            }
            if(totalHour > 12) {
                totalHour -= 12;
            }

            System.out.println("#"+i+" "+totalHour+" "+totalMin);
        }
    }
}