import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int[][][] BLOCK_CASES = {
		{{0, 0}, {0, 1}, {1, 0}, {1, 1}},
		{{0, 0}, {0, 1}, {0, 2}, {0, 3}},
		{{0, 0}, {1, 0}, {2, 0}, {3, 0}},
		{{0, 0}, {0, 1}, {0, 2}, {1, 1}},
		{{0, 0}, {0, 1}, {0, 2}, {-1, 1}},
		{{0, 0}, {1, 0}, {2, 0}, {1, 1}},
		{{0, 0}, {1, 0}, {2, 0}, {1, -1}},
		{{0, 0}, {1, 0}, {1, 1}, {2, 1}},
		{{0, 0}, {1, 0}, {1, -1}, {2, -1}},
		{{0, 0}, {0, -1}, {1, -1}, {1, -2}},
		{{0, 0}, {0, 1}, {1, 1}, {1, 2}},
		{{0, 0}, {1, 0}, {2, 0}, {2, 1}},
		{{0, 0}, {1, 0}, {2, 0}, {2, -1}},
		{{0, 0}, {1, 0}, {0, 1}, {0, 2}},
		{{0, 0}, {0, 1}, {0, 2}, {1, 2}},
		{{0, 0}, {0, 1}, {1, 1}, {2, 1}},
		{{0, 0}, {0, 1}, {1, 0}, {2, 0}},
		{{0, 0}, {1, 0}, {1, 1}, {1, 2}},
		{{1, 0}, {1, 1}, {1, 2}, {0, 2}}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int maxSum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int[][] block : BLOCK_CASES) {
					int sum = 0;
					boolean flag = true;

					for (int[] xy : block) {
						int bx = i + xy[0];
						int by = j + xy[1];

						if (bx < 0 || bx >= N || by < 0 || by >= M) {
							flag = false;
							break;
						}

						sum += map[bx][by];
					}

					if (flag)
						maxSum = Math.max(maxSum, sum);
				}
			}
		}

		System.out.println(maxSum);
		br.close();
	}
}
