package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13305 {

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        distances = new long[n];
        prices = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Long.parseLong(st.nextToken());
        }
    }

    static int n;
    static long[] distances, prices;

    public static void main(String[] args) throws Exception {
        input();

        long tmpDistance = 0;
        long result = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            tmpDistance += distances[i];
            long price = prices[i];
            if (price < min) {
                result += min * tmpDistance;
                min = price;
                tmpDistance = 0;
            }
        }
        System.out.println(result + min * tmpDistance);
    }
}
