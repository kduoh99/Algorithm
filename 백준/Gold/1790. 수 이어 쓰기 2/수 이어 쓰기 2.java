import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long k = Integer.parseInt(st.nextToken());
		long len = 1, count = 9;

		while (k > len * count) {
			k -= len * count;
			len++;
			count *= 10;
		}

		long num = (long)Math.pow(10, len - 1) + (k - 1) / len;
		if (num > N) {
			System.out.println(-1);
		} else {
			System.out.println(String.valueOf(num).charAt((int)((k - 1) % len)));
		}
	}
}
