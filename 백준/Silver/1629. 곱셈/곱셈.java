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
		long C = Long.parseLong(st.nextToken());

		long ans = pow(A, B, C);
		System.out.println(ans);
		br.close();
	}

	private static long pow(long A, long B, long C) {
		if (B == 0)
			return 1;

		long tmp = pow(A, B / 2, C) % C;
		long result = (tmp * tmp) % C;

		if (B % 2 == 0) {
			return result;
		} else {
			return (A * result) % C;
		}
	}
}