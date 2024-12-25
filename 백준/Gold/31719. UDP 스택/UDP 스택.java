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
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int last = 0, dTop = 0, dBottom = 0, pTop = 0, pBottom = 0;
			boolean flag = false;

			while (N-- > 0) {
				int v = Integer.parseInt(st.nextToken());

				if (dBottom == last + 1) {
					last = dTop;
					dBottom = dTop = 0;
				}

				if (pBottom == last + 1) {
					last = pTop;
					pBottom = pTop = 0;
				}

				if (v == last + 1) {
					last++;
				} else if (v == dTop + 1) {
					dTop++;
				} else if (v == pTop + 1) {
					pTop++;
				} else if (dBottom == 0) {
					dBottom = dTop = v;
				} else if (pBottom == 0) {
					pBottom = pTop = v;
				} else {
					flag = true;
					break;
				}
			}

			sb.append(flag ? "NO" : "YES").append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}
