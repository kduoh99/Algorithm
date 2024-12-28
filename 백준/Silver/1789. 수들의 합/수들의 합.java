import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long S = Long.parseLong(br.readLine());
		long sum = 0;
		int N = 1;

		while (true) {
			sum += N;
			if (sum > S) {
				System.out.print(N - 1);
				break;
			}
			N++;
		}
	}
}