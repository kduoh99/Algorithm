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

		for (int i = 0; i < M; i++) {
			int k = Integer.parseInt(br.readLine());
			int prev = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < k; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value > prev) {
					System.out.println("No");
					return;
				}
				prev = value;
			}
		}
		
		System.out.println("Yes");
		br.close();
	}
}
