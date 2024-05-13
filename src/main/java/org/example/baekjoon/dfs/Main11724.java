package org.example.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main11724 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();

        StringTokenizer st = new StringTokenizer(str);

        int element = Integer.parseInt(st.nextToken());
        int node = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= element; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[element+1];

        for(int i = 0; i < node; i++) {
            String nodeLine = bf.readLine();
            StringTokenizer st1 = new StringTokenizer(nodeLine);

            int element1 = Integer.parseInt(st1.nextToken());
            int element2 = Integer.parseInt(st1.nextToken());

            graph.get(element1).add(element2);
            graph.get(element2).add(element1);

        }

        int result = dfs(graph, visited);

        System.out.println(result);
    }

    public static int dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        int result = 0;

        for(int i = 1; i < graph.size(); i++) {
            if(!visited[i]) {
                dfsUtil(graph, visited, i);
                result++;
            }
        }

        return result;
    }

    public static void dfsUtil(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int i) {
        visited[i] = true;

        Iterator<Integer> it = graph.get(i).listIterator();
        while (it.hasNext()) {
            int n = it.next();

            if (!visited[n]) {
                dfsUtil(graph, visited, n);
            }
        }
    }
}