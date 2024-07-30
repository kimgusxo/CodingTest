package org.code.programmers.lv2;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NumberChange {
    public static void main(String[] args) {

        int test1 = solution(10, 40, 5);
        int test2 = solution(10, 40, 30);
        int test3 = solution(2, 5, 4);

        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);

    }

    public static int solution(int x, int y, int n) {
        int answer = 1;

        Queue<ArrayList<Integer>> dp = new LinkedList<>();

        ArrayList<Integer> values = new ArrayList<>();
        values.add(x+n);
        values.add(x*2);
        values.add(x*3);

        dp.offer(values);

        int count = 1;

        // 1번 2번 3번 4번 5번 이렇게 level별로 answer를 증가시켜야 하며
        // 그 while에서 첫번째 리스트의 모든 요소가 정답값보다 크다면 -1을 출력해야함
        while(true) {
            for(int i = 0; i < count; i++) {
                ArrayList<Integer> pollList = dp.poll();
                ArrayList<Integer> offerList = new ArrayList<>();

                offerList.add(pollList.get(0)+n);
                offerList.add(pollList.get(1)*2);
                offerList.add(pollList.get(2)*3);

                dp.offer(offerList);

                if(offerList.contains(y)) return answer;
            }

            answer++;
        }
    }

}
