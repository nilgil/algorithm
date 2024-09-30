package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1475 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = line.length();
        int[] counts = new int[10];
        for (int i = 0; i < n; i++) {
            char c = line.charAt(i);
            if (c == '6') {
                counts[9]++;
            } else {
                counts[c - '0']++;
            }
        }

        int max = 0;
        for (int i = 0; i < 9; i++) {
            max = Math.max(max, counts[i]);
        }
        int nine = counts[9] / 2;
        if (counts[9] % 2 != 0) {
            nine++;
        }
        max = Math.max(max, nine);
        System.out.println(max);
    }
}
