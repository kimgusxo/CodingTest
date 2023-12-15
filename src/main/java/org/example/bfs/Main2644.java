package org.example.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2644 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int people = Integer.parseInt(bf.readLine());

        String calc = bf.readLine();

        StringTokenizer st = new StringTokenizer(calc);

        int person1 = Integer.parseInt(st.nextToken());
        int person2 = Integer.parseInt(st.nextToken());

        int node = Integer.parseInt(bf.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= people; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[people+1];

        for(int i = 0; i < node; i++) {
            String nodeLine = bf.readLine();
            StringTokenizer st1 = new StringTokenizer(nodeLine);

            int element1 = Integer.parseInt(st1.nextToken());
            int element2 = Integer.parseInt(st1.nextToken());

            graph.get(element1).add(element2);
            graph.get(element2).add(element1);

        }

        int result = bfs(graph, visited, person1, person2);

        System.out.println(result);

    }

    public static int bfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int p1, int p2) {
        Queue<Integer> valueQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();

        int depth = 0;

        visited[p1] = true;
        valueQueue.add(p1);
        depthQueue.add(depth);

        while(!valueQueue.isEmpty()) {
            p1 = valueQueue.poll();
            depth = depthQueue.poll();

            Iterator<Integer> it = graph.get(p1).listIterator();

            while (it.hasNext()) {
                int n = it.next();
                if(n == p2) {
                    return depth+1;
                }
                if(!visited[n]) {
                    visited[n] = true;
                    valueQueue.add(n);
                    depthQueue.add(depth+1);
                }
            }
        }
        return -1;
    }
}
