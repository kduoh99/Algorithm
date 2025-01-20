import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] T = new int[n + 1];
		long[] S = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			T[i] = Integer.parseInt(st.nextToken());
			S[i] = S[i - 1] + T[i];
		}

		long max = 0L;
		for (int i = 1; i + m - 1 <= n; i++) {
			max = Math.max(max, S[i + m - 1] - S[i - 1]);
		}

		System.out.println(max);
		br.close();
	}
}
