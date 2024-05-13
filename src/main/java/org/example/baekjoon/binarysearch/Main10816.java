package org.example.baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10816 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int valueNum = Integer.parseInt(bf.readLine());

        int[] valueArr = new int[valueNum];

        String value = bf.readLine();
        StringTokenizer st = new StringTokenizer(value);

        for(int i = 0; i < valueNum; i++) {
            valueArr[i] = Integer.parseInt(st.nextToken());
        }

        int searchNum = Integer.parseInt(bf.readLine());

        int[] searchArr = new int[searchNum];

        String search = bf.readLine();
        StringTokenizer st1 = new StringTokenizer(search);

        for(int i = 0; i < searchNum; i++) {
            searchArr[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(valueArr);

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < searchArr.length; i++) {
            stringBuilder.append(endBinarySearch(valueArr, searchArr[i]) - startBinarySearch(valueArr, searchArr[i])).append(" ");
        }
        System.out.println(stringBuilder);

    }

    public static int startBinarySearch(int[] valueArr, int searchNum) {
        int start = 0;
        int end = valueArr.length;

        while(start < end) {
            int mid = (start+end)/2;

            if(valueArr[mid] >= searchNum) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }

    public static int endBinarySearch(int[] valueArr, int searchNum) {
        int start = 0;
        int end = valueArr.length;

        while(start < end) {
            int mid = (start+end)/2;

            if(valueArr[mid] > searchNum) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
}
