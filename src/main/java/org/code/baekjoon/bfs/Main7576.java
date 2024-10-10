package org.code.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main7576 {

    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int width = Integer.parseInt(br.readLine());
        int height = Integer.parseInt(br.readLine());

        int[][] box = new int[width][height];
        boolean[][] visited = new boolean[width][height];

        for(int i = 0; i < width; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < height; j++) {
                int el = Integer.parseInt(st.nextToken());
                box[i][j] = el;

                if(el == 1) {
                    visited[i][j] = true;
                }
            }
        }

        // bfs돌리고 배열 순회할 때 0이 들어있으면 -1 리턴하고 아니면 level출력
        // 근데 시작점이 여러개니까 배열을 계속 새로만들어줘야함
        // 그럼 boolean배열도 똑같이 만들어주고 true랑 아닌거랑 해줘야겟다

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int tomato = box[i][j];
                if(tomato == 1 ) {

                }
            }
        }
    }
}
