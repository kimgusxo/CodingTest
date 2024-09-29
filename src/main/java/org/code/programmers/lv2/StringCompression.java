package org.code.programmers.lv2;

import java.util.ArrayList;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(solution("aabbccc"));
    }

    public static int solution(String s) {
        int answer = 0;

        // 1. 글자를 1개부터 ~ n/2까지 압축가능
        int length = s.length();

        ArrayList<String> strList = new ArrayList<>();

        // 2. 반복돌껀데 s.length/n이 0일때만 돌기
        for (int i = 1; i <= length/2; i++) {
            if(length/i == 0) {

            }
        }

        // 3. 리스트에 담고 길이 min 찾기

        return answer;
    }
}
