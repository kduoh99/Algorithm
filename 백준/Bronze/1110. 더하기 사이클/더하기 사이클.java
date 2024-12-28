import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int start = N;
		int count = 0;

		while (true) {
			N = (N % 10 * 10) + ((N / 10 + N % 10) % 10);
			count++;

			if (start == N) break;
		}
		
		System.out.println(count);
		br.close();
	}
}
