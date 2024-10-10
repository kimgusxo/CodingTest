package org.code.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int fileCnt = Integer.parseInt(br.readLine());

        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < fileCnt; i++) {
            String file = br.readLine();

            String[] str = file.split("\\.");
            priorityQueue.add(str[1]);
        }

        while(!priorityQueue.isEmpty()) {
            int cnt = 1;
            String s = "";

            while(!priorityQueue.isEmpty()) {
                s = priorityQueue.poll();
                if (s.equals(priorityQueue.peek())) {
                    cnt++;
                } else {
                    break;
                }
            }
            System.out.println(s + " " + cnt);


        }
    }
}
