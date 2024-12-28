import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int S = Integer.parseInt(br.readLine());
		for (int i = 0; i < N - 1 && S > 0; i++) {
			int maxIdx = i;
			
			for (int j = i + 1; j < N && j - i <= S; j++) {
				if (A[maxIdx] < A[j]) maxIdx = j;
			}

			for (int k = maxIdx; k > i; k--) {
				int tmp = A[k];
				A[k] = A[k - 1];
				A[k - 1] = tmp;
			}
			
			S -= (maxIdx - i);
		}

		StringBuilder sb = new StringBuilder();
		for (int a : A)
			sb.append(a).append(' ');

		System.out.println(sb);
		br.close();
	}
}
