import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);

		char[] A = br.readLine().toCharArray();
		boolean[] visited = new boolean[N];
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			if (A[i] == 'P') {
				for (int j = i - K; j <= i + K; j++) {
					if (j < 0) continue;
					if (j >= N) break;

					if (A[j] == 'H' && !visited[j]) {
						visited[j] = true;
						cnt += 1;
						break;
					}
				}
			}
		}
		
		System.out.println(cnt);
		br.readLine();
	}
}