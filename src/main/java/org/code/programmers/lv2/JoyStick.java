package org.code.programmers.lv2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


// 1. 일단 값을 찾기 위해 알파벳 전부를 넣고 인덱스를 찾으려고 함
// 2. 맵으로 만들면 키, 밸류 쌍이므로 바로 접근가능해서 맵 채택
// 3. 현재 포인터와 키값을 비교해서 answer에 더하기
public class JoyStick {
    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
    }

    public static int solution(String name) {
        HashMap<Integer, Character> alphabet = new HashMap<>();
        for(int i = 1; i < 27; i++) {
            alphabet.put(i, (char)('A' + i - 1));
        }

        int answer = 0;

        int pointer = 0;
        int max = 26;

        ArrayList<Integer> arr = new ArrayList<>();

        // Math.abs(pointer - cur), (max-cur)+1, (cur-min)+1
        for(int i = 0; i < name.length(); i++) {
           char letter = name.charAt(i);
           int cur = alphabet.get(letter);

           int a = Math.abs(pointer - cur);
           int b = (max-cur) + 1;
           int minValue = Math.min(a, b);

           arr.add(minValue);
        }

        return answer;
    }
}
