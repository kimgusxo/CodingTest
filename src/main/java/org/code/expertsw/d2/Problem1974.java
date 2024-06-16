package org.code.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1974 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for (int i=1; i<=cnt; i++) {
            int[][] box = new int[9][9];
            int[][] partBox = new int[9][9];
            int result = 1;

            for (int j=0; j<9; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int k=0; k<9; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    box[j][k] = num;
                }
            }

            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    int index = 0;
                    for (int j = row * 3; j < (row + 1) * 3; j++) {
                        for (int k = col * 3; k < (col + 1) * 3; k++) {
                            partBox[row * 3 + col][index++] = box[j][k];
                        }
                    }
                }
            }

            for (int j=0; j<9; j++) {
                boolean[] checkBox1 = new boolean[10];
                boolean[] checkBox2 = new boolean[10];
                boolean[] checkBox3 = new boolean[10];

                for (int k=0; k<9; k++) {
                    int el1 = box[j][k];
                    int el2 = box[k][j];
                    int el3 = partBox[j][k];

                    checkBox1[el1] = true;
                    checkBox2[el2] = true;
                    checkBox3[el3] = true;
                }
                for(int k=1; k<10; k++) {
                    if (!checkBox1[k] || !checkBox2[k] || !checkBox3[k]) {
                        result = 0;
                        break;
                    }
                }
            }

            System.out.println("#"+i+" "+result);
        }

    }
}
