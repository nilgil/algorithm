package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ21921_S3 {

	static int n, x;
	static int[] counts;
	static int max = 0;
	static int maxCount = 0;

	public static void main(String[] args) throws Exception {
		input();
		for (int i = 1; i <= n - x + 1; i++) {
			int sum = counts[i + x - 1] - counts[i - 1];
			if (max < sum) {
				max = sum;
				maxCount = 1;
			} else if (max == sum) {
				maxCount++;
			}
		}

		if (max == 0) {
			System.out.println("SAD");
			return;
		}
		System.out.println(max);
		System.out.println(maxCount);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		counts = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			counts[i] = counts[i - 1] + Integer.parseInt(st.nextToken());
		}
	}
}
