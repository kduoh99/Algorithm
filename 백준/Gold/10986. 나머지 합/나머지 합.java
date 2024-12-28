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

		int rSum = 0;
		int[] rCount = new int[M];
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			rSum = (rSum + Integer.parseInt(st.nextToken())) % M;
			rCount[rSum]++;
		}

		long ans = rCount[0];
		for (int i = 0; i < M; i++) {
			if (rCount[i] > 1)
				ans += (long) rCount[i] * (rCount[i] - 1) / 2;
		}
		
		System.out.println(ans);
		br.close();
	}
}
