package org.code.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main23968 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();

        StringTokenizer st = new StringTokenizer(input);

        int number = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int[] arr = new int[number];

        String arrInput = bf.readLine();
        StringTokenizer st1 = new StringTokenizer(arrInput);

        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        int result = 0;
        int a = 0;
        int b = 0;

        for(int i = 1; i < arr.length; i++) {
            for(int j = 0; j < arr.length-i; j++) {
                if(arr[j] > arr[j+1]) {
                    result++;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    if(result == count) {
                        a = arr[j];
                        b = arr[j+1];
                    }
                }
            }
        }

        if(a == 0) {
            System.out.println(-1);
        } else {
            System.out.println(a + " " + b);
        }
    }
}
