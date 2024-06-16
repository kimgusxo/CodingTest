package org.code.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2001 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bf.readLine());

        for (int i=1; i<=count; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int boxSize = Integer.parseInt(st.nextToken());
            int smashSize = Integer.parseInt(st.nextToken());

            int[][] box = new int[boxSize][boxSize];

            for(int j=0; j<boxSize; j++) {
                StringTokenizer st1 = new StringTokenizer(bf.readLine());
                for(int k=0; k<boxSize; k++) {
                    box[j][k] = Integer.parseInt(st1.nextToken());
                }
            }

            int max = 0;

            for(int j=0; j<=boxSize-smashSize; j++) {
                for (int q=0; q<=boxSize-smashSize; q++) {
                    int sum = 0;
                    for(int k=j; k<j+smashSize; k++) {
                        for(int o=q; o<q+smashSize; o++) {
                            sum += box[k][o];
                        }
                    }

                    if(sum > max) {
                        max = sum;
                    }
                }
            }

            System.out.println("#" + i + " " + max);

        }

    }
}
