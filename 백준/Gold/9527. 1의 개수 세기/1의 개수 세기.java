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
		if (num < 2)
			return num;

		int len = 0;
		long tmp = num;
		while (tmp != 0) {
			len++;
			tmp >>= 1;
		}

		long top = 1L << (len - 1);
		return (1L << (len - 2)) * (len - 1) + num - top + 1 + count(num - top);
	}
}
