import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final int SIZE = 1_003_001;
	private static final boolean[] prime = new boolean[SIZE + 1];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		isPrime();

		for (int i = N; i <= SIZE; i++) {
			if (!prime[i] && isPalindrome(i)) {
				System.out.println(i);
				break;
			}
		}
		br.close();
	}

	private static void isPrime() {
		prime[0] = prime[1] = true;

		for (int i = 2; i * i <= SIZE; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= SIZE; j += i)
					prime[j] = true;
			}
		}
	}

	private static boolean isPalindrome(int num) {
		String S = String.valueOf(num);
		int len = S.length();

		for (int i = 0; i < len / 2; i++) {
			if (S.charAt(i) != S.charAt(len - i - 1))
				return false;
		}
		return true;
	}
}
