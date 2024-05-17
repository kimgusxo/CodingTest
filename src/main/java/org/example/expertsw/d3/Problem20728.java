package org.example.expertsw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem20728 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for(int i=1; i<=cnt; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int totalPocket = Integer.parseInt(st.nextToken());
            int selectPocket = Integer.parseInt(st.nextToken());

            ArrayList<Integer> arr = new ArrayList<>();

            st = new StringTokenizer(bf.readLine());

            while(st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(arr, Collections.reverseOrder());

            int min = arr.get(0)-arr.get(totalPocket-1);

            for(int j=0; j<=totalPocket-selectPocket; j++) {
                int diff = arr.get(j)-arr.get(j+selectPocket-1);
                if(min > diff) {
                    min = diff;
                }
            }

            System.out.println("#"+i+" "+min);

        }
    }

}
