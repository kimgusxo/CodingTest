package org.example.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem1983 {

    static final String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bf.readLine());

        for(int i=1; i<=count; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int students = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            int targetPoint = 0;

            ArrayList<Integer> arr = new ArrayList<>();

            for(int j=1; j<=students; j++) {
                StringTokenizer st1 = new StringTokenizer(bf.readLine());

                int middleTest = Integer.parseInt(st1.nextToken())*35;
                int lastTest = Integer.parseInt(st1.nextToken())*45;
                int project = Integer.parseInt(st1.nextToken())*20;

                int totalTest = middleTest+lastTest+project;

                if(j==target) targetPoint = totalTest;

                arr.add(totalTest);
            }

            Collections.sort(arr, Collections.reverseOrder());

            int targetIndex = arr.indexOf(targetPoint);
            int gradeIndex = students/10;
            int gradeRank = targetIndex/gradeIndex;

            System.out.println("#"+i+" "+grade[gradeRank]);
        }

    }
}
