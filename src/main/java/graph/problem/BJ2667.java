package graph.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ2667 {

    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    static int n;
    static boolean[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (chars[j] == '1') {
                    map[i][j] = true;
                }
            }
        }

        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] && !visited[i][j]) {
                    dfs(i, j);
                    counts.add(cnt);
                    cnt = 1;
                }
            }
        }
        counts.sort(Integer::compareTo);

        sb.append(counts.size()).append('\n');
        for (Integer count : counts) {
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    static int cnt = 1;

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nX = x + dX[i];
            int nY = y + dY[i];
            if (0 <= nX && nX < n && 0 <= nY && nY < n
                    && map[nX][nY] && !visited[nX][nY]) {
                cnt++;
                dfs(nX, nY);
            }
        }
    }
}
