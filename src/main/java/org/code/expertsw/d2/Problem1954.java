package org.code.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1954 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for(int i=1; i<=cnt; i++) {
            int number = Integer.parseInt(bf.readLine());

            int[][] result = new int[number][number];
            boolean[][] check = new boolean[number][number];

            int el = 1;
            boolean x = false;
            boolean y = false;
            int a = 0;
            int b = 0;

            for(int j=0; j<number*number; j++) {
                    if(!x && !y) {
                        result[a][b] = el++;
                        check[a][b] = true;
                        b++;
                        if(b==number || check[a][b]) {
                            y=true;
                            b--;
                            a++;
                        }
                    } else if(y && !x) {
                        result[a][b] = el++;
                        check[a][b] = true;
                        a++;
                        if(a==number || check[a][b]) {
                            x=true;
                            a--;
                            b--;
                        }
                    } else if(y) {
                        result[a][b] = el++;
                        check[a][b] = true;
                        b--;
                        if(b==-1 || check[a][b]) {
                            y=false;
                            b++;
                            a--;
                        }
                    } else {
                        result[a][b] = el++;
                        check[a][b] = true;
                        a--;
                        if(a==-1 || check[a][b]) {
                            x=false;
                            a++;
                            b++;
                        }
                    }
                }

            System.out.println("#"+i);
            for(int j=0; j<result.length; j++) {
                for(int k=0; k<result.length; k++) {
                    System.out.print(result[j][k]+" ");
                }
                System.out.println();
            }
        }
    }
}
