package com.nilgil.study.algorithm.support;

import java.util.List;

public class PrintUtils {

    public static void printIntMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("    ");
                } else if (i == 0) {
                    System.out.print(j + " ");
                } else if (j == 0) {
                    System.out.print(i + " | ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
            if (i == 0) {
                System.out.println("  "+"-".repeat(matrix.length * 2));
            }
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
