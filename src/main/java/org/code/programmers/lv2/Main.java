package org.code.programmers.lv2;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int[][] edges = {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};

        solution(edges);

    }

    public static int[] solution(int[][] edges) {
        // 0. 생성한 노드를 찾기위해서 선행조건인 최대값의 노드를 구해야함
        int max = 1;

        for(int[] edge : edges) {
            if(edge[0] > max) {
                max = edge[0];
            }
            if(edge[1] > max) {
                max = edge[1];
            }
        }

        // 1. 생성한 노드를 찾아야함
        // 1-1. 생성한 노드를 찾으려면 어떤 방식으로 찾아야할까?
        // 1-2. 오는 엣지가 0인 노드 찾기
        boolean[] flag = new boolean[max+1];

        for(int[] edge : edges) {
            flag[edge[1]] = true;
        }

        ArrayList<Integer> zeroNodes = new ArrayList<>();

        for(int i=1; i<=max; i++) {
            if(!flag[i]) {
                zeroNodes.add(i);
            }
        }

        // 1-3. 오는 엣지가 0인 노드에서 가는 엣지가 2 이상인 노드가 생성한 노드
        int createdNode = 0;
        for(Integer i : zeroNodes) {
            int cnt = 0;
            for(int[] edge : edges) {
                if(i==edge[0]) {
                    cnt++;
                }
            }
            if(cnt>=2) {
                createdNode = i;
                break;
            }
        }

        // 1-4. 탐색을 위한 그래프 생성
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<=max; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            if(edge[0]!=createdNode) {
                graph.get(edge[0]).add(edge[1]);
            }
        }

        // 2. 그래프 모양 찾기
        // 2-0. 전체 그래프 개수 찾기
        int graphCount = 0;

        // 2-1. 막대 그래프 찾기(리스트 size가 0인것)
        int barGraph = 0;
        for(int i=1; i<graph.size(); i++) {
            if(graph.get(i).size() == 0) {
                barGraph++;
            }
        }
        barGraph -= 1;

        // 2-2. 8자 그래프 찾기(리스트 size가 2인것)
        int eightGraph = 0;
        for(ArrayList<Integer> arr : graph) {
            if(arr.size() == 2) {
                eightGraph++;
            }
        }
        // 2-3. 도넛 그래프 찾기(전체 그래프 개수 - (막대+8자))
        int donutGraph = graphCount-(barGraph+eightGraph);

        int[] answer = {createdNode, donutGraph, barGraph, eightGraph};

        return answer;
    }


}
