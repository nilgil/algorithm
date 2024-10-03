package realization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1158_List {

    static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        sb.append('<');
        int current = 0;
        while (1 < nums.size()) {
            current = (current - 1 + k) % nums.size();
            sb.append(nums.get(current)).append(',').append(' ');
            nums.remove(current);
        }
        sb.append(nums.get(0)).append('>');
        System.out.println(sb);
    }
}
