package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1026 {

    static int n;
    static int[] a, b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        a = new int[n];
        b = new int[n];
        StringTokenizer aParser = new StringTokenizer(br.readLine());
        StringTokenizer bParser = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(aParser.nextToken());
            b[i] = Integer.parseInt(bParser.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i] * b[n - i - 1];
        }
        System.out.println(sum);
    }
}
