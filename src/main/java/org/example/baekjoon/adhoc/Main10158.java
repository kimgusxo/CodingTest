package org.example.baekjoon.adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10158 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int xMax = Integer.parseInt(st.nextToken());
        int yMax = Integer.parseInt(st.nextToken());

        String input1 = bf.readLine();
        StringTokenizer st1 = new StringTokenizer(input1);

        int x = Integer.parseInt(st1.nextToken());
        int y = Integer.parseInt(st1.nextToken());

        int move = Integer.parseInt(bf.readLine());

        int xMove = x + move;
        int yMove = y + move;

        int xResult = 0;
        int yResult = 0;

        if((xMove/xMax)%2 == 0) {
            xResult = xMove%xMax;
        } else {
            xResult = xMax - (xMove%xMax);
        }
        if((yMove/yMax)%2 == 0) {
            yResult = yMove%yMax;
        } else {
            yResult = yMax - (yMove%yMax);
        }

        StringBuilder sb = new StringBuilder();

        sb.append(xResult).append(' ').append(yResult);

        System.out.print(sb);

    }

}
