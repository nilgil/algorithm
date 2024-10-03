package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1316 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        while (n-- > 0) {
            boolean[] visited = new boolean['z' - 'a' + 1];
            String line = br.readLine();

            char before = line.charAt(0);
            visited[before - 'a'] = true;

            boolean flag = true;
            for (int i = 1; i < line.length(); i++) {
                char now = line.charAt(i);
                if (now == before) {
                    continue;
                }
                if (visited[now - 'a']) {
                    flag = false;
                    break;
                }
                visited[now - 'a'] = true;
                before = now;
            }
            if (flag) {
                result++;
            }
        }
        System.out.println(result);
    }
}
