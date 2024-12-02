import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());

		int per = (int) (Y * 100 / X);
		if (per >= 99) {
			System.out.println(-1);
			return;
		}

		int left = 0, right = 1_000_000_000;
		while (left < right) {
			int mid = (left + right) / 2;
			int Z = (int) ((Y + mid) * 100 / (X + mid));

			if (Z <= per) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		System.out.println(left);
		br.close();
	}
}
