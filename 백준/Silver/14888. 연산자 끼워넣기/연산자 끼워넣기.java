import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	private static int[] A, op;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		op = new int[4];
		
		for (int i = 0; i < 4; i++)
			op[i] = Integer.parseInt(st.nextToken());

		backtrack(1, A[0]);
		StringBuilder sb = new StringBuilder();
		sb.append(max).append('\n').append(min);
		
		System.out.println(sb);
		br.close();
	}

	private static void backtrack(int idx, int cur) {
		if (idx == N) {
			max = Math.max(max, cur);
			min = Math.min(min, cur);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (op[i] > 0) {
				op[i]--;
				switch (i) {
					case 0:
						backtrack(idx + 1, cur + A[idx]);
						break;
					case 1:
						backtrack(idx + 1, cur - A[idx]);
						break;
					case 2:
						backtrack(idx + 1, cur * A[idx]);
						break;
					case 3:
						backtrack(idx + 1, cur / A[idx]);
						break;
				}
				op[i]++;
			}
		}
	}
}
