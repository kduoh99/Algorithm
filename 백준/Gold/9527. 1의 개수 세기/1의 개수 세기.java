import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		System.out.println(count(B) - count(A - 1));
		br.close();
	}

	private static long count(long num) {
		long count = 0, bit = 1;

		while (bit <= num) {
			long full = num / (bit << 1);
			long remain = num % (bit << 1);

			count += full * bit + Math.max(0, remain - bit + 1);
			bit <<= 1;
		}

		return count;
	}
}
