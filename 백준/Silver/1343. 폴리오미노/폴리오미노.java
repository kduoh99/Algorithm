import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), ".", true);

		while (st.hasMoreTokens()) {
			String s = st.nextToken();

			if (s.equals(".")) {
				sb.append(".");
				continue;
			}

			if (s.length() % 2 != 0) {
				System.out.println(-1);
				return;
			}

			sb.append("AAAA".repeat(s.length() / 4));
			sb.append("BB".repeat((s.length() % 4) / 2));
		}

		System.out.println(sb);
		br.close();
	}
}
