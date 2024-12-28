import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		int total = 0, maxArea = Integer.MIN_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();

		int first = Integer.parseInt(st.nextToken());
		int prev = first;

		for (int i = 1; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int cur = Integer.parseInt(st.nextToken());
			maxArea = Math.max(cur * prev, maxArea);
			total += cur * prev;
			prev = cur;
		}

		maxArea = Math.max(prev * first, maxArea);
		total += prev * first;
		System.out.println((total - maxArea * 2) * K);
		br.close();
	}
}
