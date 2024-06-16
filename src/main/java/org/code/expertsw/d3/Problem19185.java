package org.code.expertsw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem19185 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for(int i=1; i<=cnt; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            String[] firstStr = new String[first];
            String[] secondStr = new String[second];

            st = new StringTokenizer(bf.readLine());

            for(int j=0; j<first; j++) {
                firstStr[j] = st.nextToken();
            }

            st = new StringTokenizer(bf.readLine());

            for(int j=0; j<second; j++) {
                secondStr[j] = st.nextToken();
            }

            int years = Integer.parseInt(bf.readLine());

            StringBuilder sb = new StringBuilder();

            for(int j=0; j<years; j++) {
                int year = Integer.parseInt(bf.readLine());

                int firstResult = year%first;
                if(firstResult==0) {
                    firstResult = first;
                }

                int secondResult = year%second;
                if(secondResult==0) {
                    secondResult = second;
                }

                sb.append(firstStr[firstResult-1]);
                sb.append(secondStr[secondResult-1]);
                sb.append(" ");
            }


            System.out.println("#"+i+" "+sb);

        }
    }

}

