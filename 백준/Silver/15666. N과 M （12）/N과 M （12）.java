import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final StringBuilder sb = new StringBuilder();
	private static int N, M;
	private static int[] arr, A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		st = new StringTokenizer(br.readLine());
		A = new int[N];

		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);

		dfs(0, 0);
		System.out.println(sb);
		br.close();
	}

	private static void dfs(int k, int depth) {
		if (depth == M) {
			for (int v : arr)
				sb.append(v).append(' ');
			sb.append('\n');
			return;
		}

		for (int i = k; i < N; i++) {
			arr[depth] = A[i];
			dfs(i, depth + 1);

			while (i + 1 < N && A[i] == A[i + 1])
				i++;
		}
	}
}