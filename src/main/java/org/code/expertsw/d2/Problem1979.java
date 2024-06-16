package org.code.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem1979 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= count; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int size = Integer.parseInt(st.nextToken());
            int wordLength = Integer.parseInt(st.nextToken());

            // 패턴 생성
            StringBuilder patternBuilder = new StringBuilder("0");
            for (int j = 0; j < wordLength; j++) {
                patternBuilder.append("1");
            }
            patternBuilder.append("0");
            String pattern = patternBuilder.toString();

            ArrayList<String> width = new ArrayList<>();
            ArrayList<String> height = new ArrayList<>();

            // 가로 문자열 리스트 생성
            for (int j = 0; j < size; j++) {
                String el = "0" + bf.readLine().replaceAll(" ", "") + "0";
                width.add(el);
            }

            // 세로 문자열 리스트 생성
            for (int j = 0; j < size; j++) {
                StringBuilder str = new StringBuilder("0");
                for (int k = 0; k < size; k++) {
                    str.append(width.get(k).charAt(j + 1));
                }
                str.append("0");
                height.add(str.toString());
            }

            int result = 0;

            for(int j=0; j<size; j++) {
                for(int k=0; k<=size-wordLength; k++) {
                    if(pattern.equals(width.get(j).substring(k, k+wordLength+2))) {
                        result++;
                    }
                    if(pattern.equals(height.get(j).substring(k, k+wordLength+2))) {
                        result++;
                    }
                }
            }

            System.out.println("#" + i + " " + result);
        }
    }
}
