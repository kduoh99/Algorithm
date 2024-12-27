import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		boolean[] flag = new boolean[(int) (max - min + 1)];

		for (long i = 2; ; i++) {
			long square = i * i;
			if (square > max) break;

			long t = (min / square) * square;
			if (t < min) t += square;

			while (t <= max) {
				flag[(int) (t - min)] = true;
				t += square;
			}
		}

		int cnt = 0;
		for (boolean f : flag) {
			if (!f) cnt++;
		}

		System.out.println(cnt);
		br.close();
	}
}
