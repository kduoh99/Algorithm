import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] arr = new int[15][15];
		for (int i = 1; i <= 14; i++) {
			arr[0][i] = i;
			arr[i][1] = 1;
		}

		for (int i = 1; i <= 14; i++) {
			for (int j = 1; j <= 14; j++)
				arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
		}

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(arr[k][n]).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}