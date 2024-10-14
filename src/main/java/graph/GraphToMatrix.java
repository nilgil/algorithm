package graph;

import support.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
5 3
1 2
2 3
3 1
 */
public class GraphToMatrix {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[nodeCount + 1][nodeCount + 1];

        while (edgeCount-- > 0) {
            st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            matrix[from][to] = 1;
        }

        PrintUtils.printIntMatrix(matrix);
    }
}
