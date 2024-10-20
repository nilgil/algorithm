package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14467_B1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Boolean[] locations = new Boolean[11];
		StringTokenizer st;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			boolean location = st.nextToken().equals("0");
			if (locations[num] == null) {
				locations[num] = location;
			} else if (locations[num] != location) {
				sum++;
				locations[num] = location;
			}
		}
		System.out.println(sum);
	}
}
