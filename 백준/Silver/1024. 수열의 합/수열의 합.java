import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		boolean flag = false;

		for (; L <= 100; L++) {
			int num = 2 * N - L * (L - 1);
			int den = 2 * L;

			if (num % den == 0) {
				int start = num / den;

				if (start >= 0) {
					for (int i = 0; i < L; i++)
						sb.append(start + i).append(' ');
					flag = true;
					break;
				}
			}
		}

		System.out.println(flag ? sb : -1);
		br.close();
	}
}
