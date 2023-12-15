package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();

        StringTokenizer st = new StringTokenizer(str);

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        System.out.println(height + width);
    }

}