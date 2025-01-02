import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static long X, Y;
	private static int per;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Long.parseLong(st.nextToken());
		Y = Long.parseLong(st.nextToken());

		per = (int) (Y * 100 / X);
		if (per >= 99) {
			System.out.println(-1);
			return;
		}

		System.out.println(binarySearch(0, 1_000_000_000));
		br.close();
	}

	private static int binarySearch(int left, int right) {
		while (left < right) {
			int mid = (left + right) / 2;
			int Z = (int) ((Y + mid) * 100 / (X + mid));

			if (Z <= per) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left;
	}
}
