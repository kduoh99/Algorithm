import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		int[] B = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			B[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(A);
		int[] sortedB = new int[N];
		
		for (int i = 0; i < N; i++) {
			int maxIdx = 0;

			for (int j = 1; j < N; j++) {
				if (B[maxIdx] < B[j]) maxIdx = j;
			}
			sortedB[i] = B[maxIdx];
			B[maxIdx] = -1;
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++)
			ans += A[i] * sortedB[i];

		System.out.println(ans);
		br.close();
	}
}
