package org.code.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2468 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int width = Integer.parseInt(bf.readLine());

        int[][] area = new int[width+2][width+2];

        int max = 0;

        for(int i = 1; i < width+1; i++) {
            String row = bf.readLine();
            StringTokenizer st = new StringTokenizer(row);
            for(int j = 1; j < width+1; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if(area[i][j] >= max) {
                    max = area[i][j];
                }
            }
        }

        int result = 0;

        for(int i = 0; i < max; i++) {
            boolean[][] visited = new boolean[area.length][area[0].length];
            int count = 0;
            for(int j = 1; j < width+1; j++) {
                for(int k = 1; k < width+1; k++) {
                    if(!visited[j][k] && area[j][k] > i) {
                        bfs(area, visited, i, j, k);
                        count++;
                    }
                }
            }

            if(count >= result) {
                result = count;
            }
        }

        System.out.println(result);

    }

    public static void bfs(int[][] area, boolean[][] visited, int max, int x, int y) {
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();

        visited[x][y] = true;

        xQueue.add(x);
        yQueue.add(y);

        while (!xQueue.isEmpty()) {
            x = xQueue.poll();
            y = yQueue.poll();

            for (int i = 0; i < 4; i++) {
                if (!visited[x + dx[i]][y + dy[i]] && area[x + dx[i]][y + dy[i]] > max) {
                    visited[x + dx[i]][y + dy[i]] = true;
                    xQueue.add(x + dx[i]);
                    yQueue.add(y + dy[i]);
                }
            }
        }
    }
}
