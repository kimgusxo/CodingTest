package org.code.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int node = Integer.parseInt(bf.readLine());

        int[] nodeBox = new int[node+1];
        boolean[] visited = new boolean[node+1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= node; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < node-1; i++) {
            String edge = bf.readLine();
            StringTokenizer st = new StringTokenizer(edge);

            int element1 = Integer.parseInt(st.nextToken());
            int element2 = Integer.parseInt(st.nextToken());

            graph.get(element1).add(element2);
            graph.get(element2).add(element1);
        }

        for(int i = 1; i < node; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(graph, visited, nodeBox, i);

            }
        }

        for(int i = 2; i < nodeBox.length; i++) {
            System.out.println(nodeBox[i]);
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int[] nodeBox, int num) {
        Iterator<Integer> it = graph.get(num).listIterator();

        while(it.hasNext()) {
            int n = it.next();
            if(!visited[n]) {
                nodeBox[n] = num;
                visited[n] = true;
                dfs(graph, visited, nodeBox, n);
            }
        }
    }
}
