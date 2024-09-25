package com.nilgil.study.algorithm.problem.graph.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * DFS, BFS
 */
public class Q11724 {

    static int n, m;
    static int[][] graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
                queueBfs(i);
//                stackDfs(i);
//                recursiveDfs(i);
            }
        }
        System.out.println(count);
    }

    static void queueBfs(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    static void stackDfs(int node) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited[node] = true;

        while (!stack.isEmpty()) {
            Integer now = stack.pop();
            for (int i = 1; i <= n; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    static void recursiveDfs(int node) {
        visited[node] = true;
        for (int i = 1; i <= n; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                recursiveDfs(i);
            }
        }
    }
}
