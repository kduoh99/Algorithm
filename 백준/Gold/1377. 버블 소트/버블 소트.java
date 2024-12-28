import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] A = new int[N][2];

		for (int i = 0; i < N; i++) {
			A[i][0] = Integer.parseInt(br.readLine());
			A[i][1] = i;
		}

		Arrays.sort(A, Comparator.comparingInt(o -> o[0]));
		int ans = 0;

		for (int i = 0; i < N; i++)
			ans = Math.max(A[i][1] - i, ans);

		System.out.println(ans + 1);
		br.close();
	}
}
