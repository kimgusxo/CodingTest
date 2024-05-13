package org.example.baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1920 {
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

        for(int i = 0; i < searchNum; i++) {
            System.out.println(binarySearch(valueArr, searchArr[i]));
        }

    }

    public static int binarySearch(int[] valueArr, int searchNum) {

        int start = 0;
        int end = valueArr.length-1;

        while(start <= end) {
            int mid = (start + end)/2;
            if(valueArr[mid] > searchNum) {
                end = mid-1;
            } else if(valueArr[mid] < searchNum) {
                start = mid+1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
