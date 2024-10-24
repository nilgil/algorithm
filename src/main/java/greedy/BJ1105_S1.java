package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1105_S1 {

	/**
	 * - 두 숫자의 자릿수가 다르면 8이 없는 경우의 수가 무조건 있다.
	 *   - Ex. 8888 88888, 888 1000, ...
	 * - 같은 자릿수이며 두 숫자가 다른 경우부터는 8이 없는 경우가 무조건 존재한다.
	 *   - Ex. 87888 88888 의 경우 첫번째 숫자가 달라 7000대에서 8000 대로 단위가 넘어가기에 첫 8 제외하고 8이 모두 없을 수 있다.
	 * - 같은 자릿수이며 앞부터 8로 동일한 경우는 8이 쓰일 수 밖에 없는 경우이다.
	 *   - Ex. 8879 8880 의 경우 앞 88은 자릿수가 변화 없기 때문에 꼭 필요하다.
	 * == 앞부터 8이며 동일한 갯수를 구하면 된다. (
	 *   - 8이 아니면서 같은 수는 세지 않는다.
	 *   - 다른 수 나오는 순간부터 탐색 종료한다.
	 *   	- Ex. 88282 88285 의 경우 1,2 번째 8은 ++ 해주고, 3번째의 2는 건너뛰고 4번째의 8은 ++ 5번째부터는 X
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String l = st.nextToken();
		String r = st.nextToken();

		if (l.length() != r.length()) {
			System.out.println(0);
			return;
		}

		int result = 0;
		for (int i = 0; i < l.length(); i++) {
			char lc = l.charAt(i);
			char rc = r.charAt(i);
			if (lc != rc) {
				break;
			}
			if (lc == '8') {
				result++;
			}
		}
		System.out.println(result);
	}
}
