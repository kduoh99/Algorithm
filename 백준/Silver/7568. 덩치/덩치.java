import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] x = new int[N];
		int[] y = new int[N];
		int[] rank = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}

		for (int j = 0; j < N; j++) {
			int count = 1;
			for (int k = 0; k < N; k++) {
				if (j == k) continue;
				if (x[j] < x[k] && y[j] < y[k]) {
					count++;
				}
			}
			rank[j] = count;
			sb.append(rank[j]).append(" ");
		}
		
		System.out.println(sb);
		br.close();
	}
}