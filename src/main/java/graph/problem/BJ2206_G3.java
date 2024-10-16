package graph.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2206_G3 {

	static int[] dX = {-1, 1, 0, 0};
	static int[] dY = {0, 0, -1, 1};
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] visitedWithBreak;
	static Queue<Node> queue = new LinkedList<>();

	static class Node {
		int x;
		int y;
		int distance;
		boolean broke;

		public Node(int x, int y, int distance, boolean broke) {
			this.x = x;
			this.y = y;
			this.distance = distance;
			this.broke = broke;
		}
	}

	private static void bfs() {
		visited[1][1] = true;
		queue.offer(new Node(1, 1, 1, false));

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if (node.x == n && node.y == m) {
				System.out.println(node.distance);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nX = node.x + dX[i];
				int nY = node.y + dY[i];
				int nD = node.distance + 1;
				if (nX < 1 || n < nX || nY < 1 || m < nY) {
					continue;
				}

				// 다음 칸이 벽이면
				if (map[nX][nY] == 1) {
					// 벽을 부순적 없다면
					if (!node.broke) {
						// 다음 칸이 벽이기에 부수고 방문 체크
						visitedWithBreak[nX][nY] = true;
						queue.offer(new Node(nX, nY, nD, true));
					}
					// 벽을 부순적 있다면 진행 불가능기에 해당 경로 탐색 마무리
					else {
						continue;
					}
				}
				// 다음 칸이 벽이 아니면
				else {
					// 벽을 부순적 없다면
					if (!node.broke) {
						// 부순적 없이 방문한 경우가 이미 있다면
						if (visited[nX][nY]) {
							continue;
						}
						// 다음 칸이 벽이 아니기에 안부수고 방문 체크
						visited[nX][nY] = true;
						queue.offer(new Node(nX, nY, nD, false));
					}
					// 벽을 부순적 있다면
					else {
						// 부순적 있이 방문한 경우가 이미 있다면 경로 탐색 종료
						if (visitedWithBreak[nX][nY]) {
							continue;
						}
						// 이전에 벽을 부쉈기에 breakVisit 체크
						visitedWithBreak[nX][nY] = true;
						queue.offer(new Node(nX, nY, nD, true));
					}
				}
			}
		}
		System.out.println(-1);
	}

	public static void main(String[] args) throws Exception {
		input();
		bfs();
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];
		visitedWithBreak = new boolean[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			String line = br.readLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = line.charAt(j - 1) - '0';
			}
		}
	}
}
