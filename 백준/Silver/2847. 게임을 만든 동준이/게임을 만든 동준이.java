import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];

		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(br.readLine());

		int cnt = 0;
		for (int i = N - 1; i > 0; i--) {
			while (A[i] <= A[i - 1]) {
				A[i - 1]--;
				cnt++;
			}
		}

		System.out.println(cnt);
		br.close();
	}
}