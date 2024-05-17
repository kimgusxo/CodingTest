package org.example.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1285 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for(int i=1; i<=cnt; i++) {
            int people = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int j=0; j<people; j++) {
                queue.add(Math.abs(Integer.parseInt(st.nextToken())));
            }

            int min = queue.remove();
            int count = 1;

            for(Integer el : queue) {
                int num = queue.poll();

                if(min==num) {
                    count++;
                } else {
                    break;
                }
            }

            System.out.println("#"+i+" "+min+" "+count);
        }
    }
}
