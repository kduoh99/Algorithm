import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static boolean[] prime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		prime = new boolean[B + 1];
		isPrime(B);

		for (int i = A; i <= B; i++) {
			if (!prime[i] && isPalindrome(i))
				sb.append(i).append('\n');
		}
		
		sb.append(-1);
		System.out.println(sb);
		br.close();
	}

	private static void isPrime(int B) {
		for (int i = 2; i * i <= B; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= B; j += i)
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
