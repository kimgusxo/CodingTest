package org.example.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1388 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();

        StringTokenizer st = new StringTokenizer(str);

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        char[][] arr = new char[height][width];

        for(int i = 0; i < height; i++) {
            String widthElement = bf.readLine();
            for(int j = 0; j < widthElement.length(); j++) {
                arr[i][j] = widthElement.charAt(j);
            }
        }

        int result = dfs(arr);

        System.out.println(result);

    }

    public static int dfs(char[][] arr) {
        int result = 0;
        boolean[][] visit = new boolean[arr.length][arr[0].length];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(!visit[i][j]) {
                    visited(arr, visit, i, j);
                    result++;
                }
            }
        }

        return result;
    }

    public static void visited(char[][] arr, boolean[][] visit, int i, int j) {
        if(arr[i][j] == '-') {
            for(int k = j; k < arr[0].length; k++) {
                if(arr[i][k] == '-' && !visit[i][k]) {
                    visit[i][k] = true;
                } else {
                    break;
                }
            }
        } else {
            for(int q = i; q < arr.length; q++) {
                if(arr[q][j] == '|' && !visit[q][j]) {
                    visit[q][j] = true;
                } else {
                    break;
                }
            }
        }
    }
}