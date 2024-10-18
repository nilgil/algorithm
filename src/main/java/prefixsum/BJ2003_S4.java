package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2003_S4 {

	static int n, m;
	static int[] nums;
	static int l = 0, r = 0, sum = 0, count = 0;

	public static void main(String[] args) throws Exception {
		input();

		while (true) {
			if (m <= sum) {
				sum -= nums[l++];
			} else if (r == n) {
				break;
			} else {
				sum += nums[r++];
			}
			if (sum == m) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
	}
}
