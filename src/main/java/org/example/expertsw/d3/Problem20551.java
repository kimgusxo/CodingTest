package org.example.expertsw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem20551 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for(int i=1; i<=cnt; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int[] candy = new int[3];

            for(int j=0; j<candy.length; j++) {
                candy[j] = Integer.parseInt(st.nextToken());
            }

            int eatCandy = 0;

            if(candy[2] < 3) {
                eatCandy = -1;
            } else if(candy[1] < 2) {
                eatCandy = -1;
            }
            else {
                for(int j=candy.length-1; j>0; j--) {
                    if(candy[j] <= candy[j-1]) {
                        eatCandy += (candy[j-1]-candy[j])+1;
                        candy[j-1] = candy[j-1]-eatCandy;
                    }
                }
            }

            System.out.println("#"+i+" "+eatCandy);

        }
    }

}

