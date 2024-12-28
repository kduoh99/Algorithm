import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int P = Integer.MAX_VALUE;
		int EA = Integer.MAX_VALUE;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int ea = Integer.parseInt(st.nextToken());

			if (P > p) P = p;
			if (EA > ea) EA = ea;
		}

		int ans_A = N % 6 == 0 ? N / 6 * P : (N / 6 + 1) * P;
		int ans_B = N * EA;
		int ans_C = (N / 6 * P) + (N % 6 * EA);

		System.out.println(Math.min(ans_A, Math.min(ans_B, ans_C)));
		br.close();
	}
}
