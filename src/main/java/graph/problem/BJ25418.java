package com.nilgil.study.algorithm.graph.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS, Greedy, DP
 */
public class BJ25418 {

    static int a, k;
    static int[] counts;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        counts = new int[k + 1];

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(a);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            if (now == k) {
                return counts[k];
            }

            int multi = now * 2;
            if (multi <= k && counts[multi] == 0) {
                counts[multi] = counts[now] + 1;
                queue.offer(multi);
            }

            int add = now + 1;
            if (add <= k && counts[add] == 0) {
                counts[add] = counts[now] + 1;
                queue.offer(add);
            }
        }
        return -1;
    }
}
