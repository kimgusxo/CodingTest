package org.code.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for(int i=1; i<=cnt; i++) {
            int length = Integer.parseInt(bf.readLine());

            StringTokenizer st = new StringTokenizer(bf.readLine());
            ArrayList<Integer> arr = new ArrayList<>();

            for(int j=0; j<length; j++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(arr);

            System.out.print("#"+i+" ");
            arr.stream().forEach((w) -> System.out.print(w+" "));
            System.out.println();
        }
    }
}
