package com.nilgil.study.algorithm.support;

import java.util.List;

public class PrintUtils {

    public static void printIntMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static <T> void printListArray(List<T>[] graph) {
        for (int i = 1; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for (T to : graph[i]) {
                System.out.print(to + " ");
            }
            System.out.println();
        }
    }
}
