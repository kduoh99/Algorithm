import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int start = 1, end = 2, sum = 1, count = 0;

		while (start <= N) {
			if (sum == N) {
				count++;
				sum += end;
				end++;
			}

			if (sum < N) {
				sum += end;
				end++;
			} else {
				sum -= start;
				start++;
			}
		}
		
		System.out.println(count);
		br.close();
	}
}