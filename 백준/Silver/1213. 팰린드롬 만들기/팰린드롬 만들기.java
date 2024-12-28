import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] alpha = new int[26];
		String str = br.readLine();

		for (int i = 0; i < str.length(); i++)
			alpha[str.charAt(i) - 'A']++;

		int oddCount = 0;
		char oddChar = ' ';

		for (int i = 0; i < 26; i++) {
			if (alpha[i] % 2 != 0) {
				oddCount++;
				oddChar = (char) (i + 'A');
			}
		}

		if (oddCount > 1) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			char ch = (char) (i + 'A');
			int idx = alpha[i] / 2;
			sb.append(String.valueOf(ch).repeat(Math.max(0, idx)));
		}

		String leftPart = sb.toString();
		String rightPart = new StringBuilder(leftPart).reverse().toString();

		if (oddCount == 1)
			sb.append(oddChar);
		sb.append(rightPart);

		System.out.println(sb);
		br.close();
	}
}
