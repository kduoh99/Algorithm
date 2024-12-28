import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] A = new int[N][M];
		int[][] B = new int[N][M];

		for (int i = 0; i < N; i++) {
			String L = br.readLine();

			for (int j = 0; j < M; j++) {
				A[i][j] = L.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			String L = br.readLine();

			for (int j = 0; j < M; j++) {
				B[i][j] = L.charAt(j) - '0';
			}
		}

		int cnt = 0;
		for (int i = 0; i <= N - 3; i++) {
			for (int j = 0; j <= M - 3; j++) {
				if (A[i][j] != B[i][j]) {
					for (int r = i; r < i + 3; r++) {
						for (int c = j; c < j + 3; c++) {
							A[r][c] = A[r][c] == 0 ? 1 : 0;
						}
					}
					cnt++;
				}
			}
		}

		boolean flag = false;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] != B[i][j]) {
					flag = true;
					break;
				}
			}
			
			if (flag) break;
		}

		System.out.println(flag ? -1 : cnt);
		br.close();
	}
}
