package org.example.sw.expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bf.readLine());

        for(int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(start > end) {
                int temp = end;
                end = start;
                start = temp;
            }

            int result = feeCalc(start, end);

            System.out.println("#" + i + " " + result);
        }

    }

    public static int feeCalc(int start, int end) {
        if(start == end) {
            return 0;
        }

        // 1. 수직 차이를 구함
        int startVerticalLevel = rangeCalc(start, 1);
        int endVerticalLevel = rangeCalc(end, startVerticalLevel);
        int verticalDiff = endVerticalLevel - startVerticalLevel;

        // 2. 수평 차이를 구함
        // 2-1. 수평의 범위가 수직 레벨차이만큼 남
        int startHorizontalLevel = start - ((startVerticalLevel*(startVerticalLevel-1)/2)+1);
        int endHorizontalLevel = end - ((endVerticalLevel*(endVerticalLevel-1)/2)+1);

        int horizontalDiff = startHorizontalLevel-endHorizontalLevel;

        // 2-2. 수평시작이 수평종료보다 작으면 범위계산 아니면 바로 더하기
        if(horizontalDiff > 0) {
            return verticalDiff + horizontalDiff;
        } else {
            int absHorizontalDiff = Math.abs(horizontalDiff);

            // 3. 수평차이가 수직차이보다 클 때 수평이동이 발생
            if(absHorizontalDiff > verticalDiff) {
                absHorizontalDiff -= verticalDiff;
            } else {
                absHorizontalDiff = 0;
            }

            // 4. 두개를 더하면 정답
            return verticalDiff + absHorizontalDiff;
        }

    }

    public static int rangeCalc(int num, int startLevel) {
        int level = startLevel;
        while(num > level*(level+1)/2) {
            level++;
        }
        return level;
    }

}
