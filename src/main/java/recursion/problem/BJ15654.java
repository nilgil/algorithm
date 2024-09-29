package recursion.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [Permutation] BJ-15654 N과 M (1초/512MB)
 * <br> - N개의 자연수 집합에서 M개를 고른 수열을 모두 출력하라.
 * <br> - 1 <= M <= N <= 8, 원소 <= 10,000
 * <br> - 수열은 사전 순으로 출려한다.
 * <br> - 중복되는 수열을 여러 번 출력하면 안된다. (문제에서 모두 다른 수라고 주어짐)
 * <br> - 최대 조합의 개수는 8!
 */
public class BJ15654 {

    static int n, m;
    static int[] nums;
    static boolean[] check;
    static int[] output;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        check = new boolean[n];
        output = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        perm(0);
        System.out.println(sb);
    }

    static StringBuilder sb = new StringBuilder();

    static void perm(int depth) {
        // base case
        if (depth == m) {                           // 원하는 원소 개수 순열 조합시
            for (int i = 0; i < m; i++) {           // 결과본 출력
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // recursive case
        for (int i = 0; i < n; i++) {
            if (!check[i]) {                // 아직 안들렀다면
                check[i] = true;            // 이제 들렀다는 마킹
                output[depth] = nums[i];    // 지금 만들고있는 순열 결과본에 추가
                perm(depth + 1);            // 다음 뎁스 진행 -> 현재 check가 true여서 다음 숫자로
                check[i] = false;           // 다른 조합을 위해 check 해제
            }
        }
    }
}
