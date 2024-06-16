package org.code.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1946 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for(int i=1; i<=cnt; i++) {
            int num = Integer.parseInt(bf.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("#"+i+"\n");
            int line = 0;

            for(int j=0; j<num; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());

                String word = st.nextToken();
                int repeat = Integer.parseInt(st.nextToken());

                for(int k=0; k<repeat; k++) {
                    sb.append(word);
                    line++;

                    if(line%10 == 0) sb.append("\n");
                }
            }

            System.out.println(sb);
        }
    }
}