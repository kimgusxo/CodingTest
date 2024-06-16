package org.code.expertsw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for(int i=1; i<=cnt; i++) {

            int length = Integer.parseInt(bf.readLine());

            ArrayList<Integer> firstDay = new ArrayList<>();
            ArrayList<Integer> secondDay = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(bf.readLine());

            for(int j=0; j<length; j++) {
                firstDay.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(bf.readLine());

            for(int j=0; j<length; j++) {
                secondDay.add(Integer.parseInt(st.nextToken()));
            }

            int[][] result = new int[length][length];

            for(int j=0; j<length; j++) {
                result[j][0] = firstDay.get(0);
                result[j][1] = secondDay.get(0);
                if(result[j][0] == result[j][1]) {
                    break;
                } else {
                    for(int k=2; k<length; k++) {
                        result[j][k] = firstDay.indexOf(result[j][k-1])+1;
                        if(result[j][0] == result[j][k]) {
                            break;
                        }
                    }
                }
            }

            int max = 0;
            int size = 0;

            for(int j=0; j<length; j++) {
                size = 0;
                for(int k=0; k<length; k++) {
                    if(result[j][k] != 0) {
                        size++;
                    }
                }
                if(size >= max) {
                    max = size;
                }
            }

            System.out.println("#"+i+" "+(max-1));

        }
    }
}
