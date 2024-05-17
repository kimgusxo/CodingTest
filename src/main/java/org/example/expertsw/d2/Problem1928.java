package org.example.expertsw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem1928 {

    static String decode = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());

        for(int i=1; i<=cnt; i++) {
            /*
            word: Lif

            아스키
            76 105 102

            2진수
            01001100 01101001 01100110

            6비트씩
            010011 000110 100101 100110
            */

            // 1. 글자 4개씩 가져와서 2진수 6비트 4묶음
            // 2. 2진수붙여서 8비트 3묶음
            // 3. 10진수로 변환 뒤 아스키코드로

            String str = bf.readLine();

            ArrayList<StringBuilder> arr = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for(int j=0; j<str.length(); j+=4) {
                String word = str.substring(j, j+4);
                StringBuilder buffer = new StringBuilder();

                for(int k=0; k<word.length(); k++) {
                    for(int q=0; q<decode.length(); q++) {
                        if(word.charAt(k) == decode.charAt(q)) {
                            String data = Integer.toString(q, 2);
                            if(data.length() < 6) {
                                for(int o=data.length(); o<6; o++) {
                                    buffer.append("0");
                                }
                            }
                            buffer.append(data);
                            break;
                        }
                    }
                }
                arr.add(buffer);
            }

            for(int j=0; j<arr.size(); j++) {
                StringBuilder sb = arr.get(j);
                for(int k=0; k<sb.length(); k+=8) {
                    char el = (char) Integer.parseInt(sb.substring(k, k+8), 2);
                    result.append(el);
                }
            }

            System.out.println("#"+i+" "+result);

        }
    }
}
