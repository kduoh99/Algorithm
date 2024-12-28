import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String seat = br.readLine();
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			if (seat.charAt(i) == 'S') {
				cnt++;
			} else {
				cnt++;
				i++;
			}
		}

		System.out.println(N > cnt ? cnt + 1 : N);
		br.close();
	}
}