package com.nilgil.study.algorithm.graph;

import com.nilgil.study.algorithm.support.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
5 3
1 2
2 3
3 1
 */
public class GraphToList {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            graph[i] = new ArrayList<>();
        }

        while (edgeCount-- > 0) {
            st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
        }
        PrintUtils.printListArray(graph);
    }
}
