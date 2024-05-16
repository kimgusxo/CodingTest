package org.example.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1961 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for (int i=1; i<=cnt; i++) {
            int size = Integer.parseInt(bf.readLine());
            int[][] box = new int[size][size];

            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int j=0; j<size; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int k=0; k<size; k++) {
                    arrayList.add(Integer.parseInt(st.nextToken()));
                }
            }

            int[][] box90 = new int[size][size];
            int[][] box180 = new int[size][size];
            int[][] box270 = new int[size][size];

            int seq90 = 0;
            int seq180 = 0;
            int seq270 = 0;

            // 90도
            for (int j=size-1; j>=0; j--) {
                for (int k=0; k<size; k++) {
                    int num = arrayList.get(seq90);
                    box90[k][j] = num;
                    seq90++;
                }
            }

            // 180도
            for (int j=size-1; j>=0; j--) {
                for (int k=size-1; k>=0; k--) {
                    int num = arrayList.get(seq180);
                    box180[j][k] = num;
                    seq180++;
                }
            }
                // 270도
            for(int j=0; j<size; j++) {
                for (int k=size-1; k>=0; k--) {
                    int num = arrayList.get(seq270);
                    box270[k][j] = num;
                    seq270++;
                }
            }


            List<int[][]> boxList = Arrays.asList(box90, box180, box270);


            System.out.println("#"+i);
            for(int j=0; j<size; j++) {
                StringBuilder sb = new StringBuilder();
                for(int k=0; k<3; k++) {
                    int[][] result = boxList.get(k);
                    for(int q=0; q<size; q++) {
                        sb.append(result[j][q]);
                    }
                    sb.append(" ");
                }
                System.out.print(sb);
                System.out.println();
            }

        }
    }
}
