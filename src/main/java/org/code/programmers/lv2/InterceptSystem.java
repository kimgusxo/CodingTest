package org.code.programmers.lv2;

import java.util.Arrays;

public class InterceptSystem {
    public static void main(String[] args) {
        int[][] target = {{7, 8}, {2, 9}, {6, 9}, {4, 12}, {9, 13}, {6, 7}, {3, 8}, {3, 6}, {2, 4}};
        System.out.println(solution(target));
    }

    public static int solution(int[][] targets) {
        int answer = 1;

        // 2차원 배열 정렬하기
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        // 먼저 앞숫자가 다음 앞숫자보다 작거나 같고
        // 먼저 뒷숫자가 다음 앞숫자보다 커야함
        int start = targets[0][0];
        int end = targets[0][1];

        for (int i = 1; i < targets.length; i++) {
            int next = targets[i][0];
            if(next >= start && next < end) {
                continue;
            } else {
                start = targets[i][0];
                end = targets[i][1];
                answer++;
            }
        }
        return answer;
    }
}
