package org.code.baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine());

        Map<String, ArrayList<String>> tree = new HashMap<>();

        for(int i = 0; i < num; i++) {
            String node = bf.readLine();
            StringTokenizer st = new StringTokenizer(node);

            ArrayList<String> list = new ArrayList<>();

            String key = st.nextToken();
            String leftNode = st.nextToken();
            String rightNode = st.nextToken();

            list.add(leftNode);
            list.add(rightNode);

            tree.put(key, list);


        }

        StringBuilder sbPrefix = new StringBuilder();
        prefix(tree, "A", sbPrefix);
        System.out.println(sbPrefix);

        StringBuilder sbInfix = new StringBuilder();
        infix(tree, "A", sbInfix);
        System.out.println(sbInfix);

        StringBuilder sbPostfix = new StringBuilder();
        postfix(tree, "A", sbPostfix);
        System.out.println(sbPostfix);
    }

    public static void prefix(Map<String, ArrayList<String>> tree, String key, StringBuilder sb) {
        if (key.equals(".")) {
            return;
        }

        ArrayList<String> children = tree.get(key);
        String leftChild = children.get(0);
        String rightChild = children.get(1);

        sb.append(key);
        prefix(tree, leftChild, sb);
        prefix(tree, rightChild, sb);

    }

    public static void infix(Map<String, ArrayList<String>> tree, String key, StringBuilder sb) {
        if (key.equals(".")) {
            return;
        }

        ArrayList<String> children = tree.get(key);
        String leftChild = children.get(0);
        String rightChild = children.get(1);

        infix(tree, leftChild, sb);
        sb.append(key);
        infix(tree, rightChild, sb);
    }

    public static void postfix(Map<String, ArrayList<String>> tree, String key, StringBuilder sb) {
        if (key.equals(".")) {
            return;
        }

        ArrayList<String> children = tree.get(key);
        String leftChild = children.get(0);
        String rightChild = children.get(1);

        postfix(tree, leftChild, sb);
        postfix(tree, rightChild, sb);
        sb.append(key);
    }

}
