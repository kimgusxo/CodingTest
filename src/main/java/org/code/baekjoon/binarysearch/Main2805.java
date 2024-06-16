package org.code.baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2805 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();

        StringTokenizer st = new StringTokenizer(input);

        int treeNum = Integer.parseInt(st.nextToken());
        long treeCount = Long.parseLong(st.nextToken());

        long[] treeArr = new long[treeNum];

        String treeIndex = bf.readLine();
        StringTokenizer st1 = new StringTokenizer(treeIndex);

        for (int i = 0; i < treeNum; i++) {
            treeArr[i] = Long.parseLong(st1.nextToken());
        }

        Arrays.sort(treeArr);

        long max = treeArr[treeNum - 1];

        System.out.println(treeCut(treeArr, max, treeCount));
    }

    public static long treeCut(long[] treeArr, long max, long treeCount) {
        long start = 0;
        boolean flag = false;

        while (start <= max) {
            long length = 0;
            long mid = (start + max) / 2;

            for (int i = 0; i < treeArr.length; i++) {
                long oneLength = treeArr[i] - mid;
                if (oneLength > 0) {
                    length += oneLength;
                }
            }

            if (length < treeCount) {
                max = mid - 1;
                flag = false;
            } else if (length > treeCount) {
                start = mid + 1;
                flag = true;
            } else {
                return mid;
            }
        }

        return flag ? max : start - 1;
    }
}
