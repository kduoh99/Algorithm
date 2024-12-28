import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][2];

			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
			int cnt = 1;
			int min = arr[0][1];

			for (int k = 1; k < N; k++) {
				if (min > arr[k][1]) {
					cnt++;
					min = arr[k][1];
				}
			}
			sb.append(cnt).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}
