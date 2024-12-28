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

		int left = 0, right = N - 1;
		int ans = Integer.MAX_VALUE;

		while (left < right) {
			int sum = A[left] + A[right];

			if (Math.abs(ans) > Math.abs(sum)) {
				ans = sum;
			}

			if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}

		System.out.println(ans);
		br.close();
	}
}
