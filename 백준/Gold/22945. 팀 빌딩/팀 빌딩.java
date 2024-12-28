import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] X = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			X[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = N - 1;
		int ans = 0;

		while (left < right) {
			int status = (right - left - 1) * Math.min(X[left], X[right]);
			ans = Math.max(ans, status);

			if (X[left] < X[right]) {
				left++;
			} else {
				right--;
			}
		}

		System.out.println(ans);
		br.close();
	}
}
