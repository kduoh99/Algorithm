import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			a %= 10;
			int ans = 1;
			for (int j = 0; j < b; j++) {
				ans *= a;
				ans %= 10;
			}

			sb.append(ans == 0 ? 10 : ans).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}
