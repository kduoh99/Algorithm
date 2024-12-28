import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		System.out.println(countSeq(N));
		br.close();
	}

	static int countSeq(int N) {
		int cnt = 99;

		if (N < 100) {
			return N;
		} else {
			for (int i = 100; i <= N; i++) {
				int h = i / 100;
				int t = (i / 10) % 10;
				int u = i % 10;

				if (h - t == t - u) cnt++;
			}
			
			return cnt;
		}
	}
}
