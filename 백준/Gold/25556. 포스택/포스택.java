import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int SIZE = 4;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] stack = {0, 0, 0, 0};
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int v = Integer.parseInt(st.nextToken());
			boolean flag = false;

			for (int j = 0; j < SIZE; j++) {
				if (stack[j] < v) {
					stack[j] = v;
					flag = true;
					break;
				}
			}

			if (!flag) {
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");
		br.close();
	}
}
