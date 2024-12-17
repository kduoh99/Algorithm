import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;

		while (true) {
			boolean flag = false;
			for (int i = 1; i <= N; i++) {
				while (A[i] < A[i - 1]) {
					A[i] *= 2;
					count++;
					flag = true;
				}
			}
			if (!flag)
				break;
		}

		System.out.println(count);
		br.close();
	}
}
