import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final StringBuilder sb = new StringBuilder();
	private static int N, M;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		dfs(1, 0);
		System.out.println(sb);
		br.close();
	}

	private static void dfs(int k, int depth) {
		if (depth == M) {
			for (int v : arr) {
				sb.append(v).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = k; i <= N; i++) {
			arr[depth] = i;
			dfs(i + 1, depth + 1);
		}
	}
}