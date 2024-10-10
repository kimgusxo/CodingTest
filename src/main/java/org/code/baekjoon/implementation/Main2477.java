package org.code.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2477 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int krMelon = Integer.parseInt(br.readLine());

        ArrayList<Integer> box = new ArrayList<>();

        int maxWidth = 0;
        int maxHeight = 0;

        int xIdx = 0;
        int yIdx = 0;

        int result = 0;

        // 최대 높이 x 최대 넓이에서 첫번째 가로 x 두번째 세로 곱하면됨
        for(int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int direction = Integer.parseInt(st.nextToken());

            if(direction == 1 || direction == 2) {
                int x = Integer.parseInt(st.nextToken());

                if(x > maxWidth) {
                    maxWidth = x;
                    xIdx = i;
                }

                box.add(x);
            }

            if(direction == 3 || direction == 4) {
                int y = Integer.parseInt(st.nextToken());

                if(y > maxHeight) {
                    maxHeight = y;
                    yIdx = i;
                }

                box.add(y);
            }
        }

        int maxIdx = Math.max(xIdx, yIdx);
        int minIdx = Math.min(xIdx, yIdx);

        result = krMelon * ((maxWidth * maxHeight) - (box.get((maxIdx+3)%6) * box.get((minIdx+3)%6)));

        System.out.println(result);
    }
}
