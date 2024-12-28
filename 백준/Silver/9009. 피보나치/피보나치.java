import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	private static final int SIZE = 45;
	private static int[] fib;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		fib = new int[SIZE];
		fib[0] = 0;
		fib[1] = 1;

		for (int i = 2; i < SIZE; i++)
			fib[i] = fib[i - 1] + fib[i - 2];

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0){
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();

			for (int i = 44; i > 0; i--) {
				if (fib[i] <= n) {
					list.add(fib[i]);
					n -= fib[i];
				}
			}

			Collections.reverse(list);
			for (int num : list)
				sb.append(num).append(' ');
			sb.append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}
