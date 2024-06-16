package org.code.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem2007 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bf.readLine());

        for (int i=1; i<=count; i++) {
            String str = bf.readLine();
            ArrayList<Integer> pattern = new ArrayList<>();

            for(int j=1; j<str.length()/2; j++) {
                String one = str.substring(0,j);
                String two = str.substring(j, j+j);
                if(one.equals(two)) {
                    pattern.add(j);
                };
            }

            System.out.println("#" + i + " " + pattern.get(0));
        }
    }
}
