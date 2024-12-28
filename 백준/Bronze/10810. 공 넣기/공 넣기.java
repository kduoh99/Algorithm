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
		int[] basket = new int[N];

		for (int l = 0; l < M; l++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			for (int idx = i - 1; idx < j; idx++)
				basket[idx] = k;
		}

		StringBuilder sb = new StringBuilder();
		for (int l = 0; l < N; l++)
			sb.append(basket[l]).append(' ');

		System.out.println(sb);
		br.close();
	}
}