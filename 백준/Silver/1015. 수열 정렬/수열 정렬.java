import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<int[]> A = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int v = Integer.parseInt(st.nextToken());
			A.add(new int[] {v, i});
		}

		A.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		int[] P = new int[N];

		for (int i = 0; i < N; i++) {
			P[A.get(i)[1]] = i;
		}

		StringBuilder sb = new StringBuilder();
		for (int p : P)
			sb.append(p).append(' ');

		System.out.println(sb);
		br.close();
	}
}
