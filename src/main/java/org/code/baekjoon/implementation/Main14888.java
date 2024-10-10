package org.code.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 이거 숫자 리스트에 넣고 연산자 순열 돈 뒤에 Collections.max, Collections.min으로 최대/최소 찾으면 될듯??
public class Main14888 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCnt = Integer.parseInt(br.readLine());

        int[] numArr = new int[numCnt];
        int[] opArr = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < numCnt; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            opArr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> result = new ArrayList<>();

        // 재귀돌려서 각각 값을 넣으면 될듯?, 풀고나니까 dfs 재귀방식과 완벽히 동일
        calculate(numArr, opArr, numArr[0], 1, result);

        System.out.println(Collections.max(result));
        System.out.println(Collections.min(result));
    }

    static void calculate(int[] numArr, int[] opArr, int start, int pointer, ArrayList<Integer> result) {
        if (pointer == numArr.length) {
            result.add(start);
        }

        for (int i = 0; i < 4; i++) {
            if (opArr[i] > 0) {
                opArr[i]--;
                switch (i) {
                    case 0:
                        calculate(numArr, opArr, start+numArr[pointer], pointer + 1, result);
                        break;
                    case 1:
                        calculate(numArr, opArr, start-numArr[pointer], pointer + 1, result);
                        break;
                    case 2:
                        calculate(numArr, opArr, start*numArr[pointer], pointer + 1, result);
                        break;
                    case 3:
                        calculate(numArr, opArr, start/numArr[pointer], pointer + 1, result);
                        break;
                }
                opArr[i]++;
            }
        }
    }
}
