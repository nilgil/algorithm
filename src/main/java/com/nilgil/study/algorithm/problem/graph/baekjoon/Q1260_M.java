package com.nilgil.study.algorithm.problem.graph.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * DFS, BFS
 */
public class Q1260_M {
    private static List<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        graph = new ArrayList[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= edgeCount; i++) {
            st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        visited = new boolean[nodeCount + 1];
        recursiveDfs(startNode);
        System.out.println();
        visited = new boolean[nodeCount + 1];
        bfs(startNode);
    }

    private static void recursiveDfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        graph[node]
                .stream()
                .sorted()
                .filter(integer -> !visited[integer])
                .forEach(Q1260_M::recursiveDfs);
    }

    private static void bfs(int startNode) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startNode);
        visited[startNode] = true;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            System.out.print(node + " ");
            graph[node]
                    .stream()
                    .sorted()
                    .filter(integer -> !visited[integer])
                    .forEach(integer -> {
                        queue.add(integer);
                        visited[integer] = true;
                    });
        }
    }
}
