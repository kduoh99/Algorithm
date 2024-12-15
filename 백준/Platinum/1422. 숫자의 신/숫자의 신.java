import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		String[] A = new String[K];
		int max = 0;

		for (int i = 0; i < K; i++) {
			A[i] = br.readLine();
			max = Math.max(max, Integer.parseInt(A[i]));
		}

		Arrays.sort(A, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

		StringBuilder sb = new StringBuilder();
		boolean flag = false;

		for (String a : A) {
			sb.append(a);

			if (!flag && max == Integer.parseInt(a)) {
				sb.append(a.repeat(Math.max(0, N - K)));
				flag = true;
			}
		}

		System.out.println(sb);
		br.close();
	}
}
