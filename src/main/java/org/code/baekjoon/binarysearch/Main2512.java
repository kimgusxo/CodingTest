package org.code.baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2512 {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < cnt; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int result = Integer.parseInt(br.readLine());

        System.out.println(calc(result));
    }

    public static int calc(int result) {

        if(result < pq.peek()) {
            return result;
        }

        int remain = result;
        int answer = 0;

        while(!pq.isEmpty()) {
            if(remain/pq.size() < pq.peek()) {
                answer = remain/pq.size();
                break;
            }
            answer = pq.peek();
            remain -= pq.poll();
        }
        return answer;
    }
}
