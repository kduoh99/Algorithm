import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		String S = br.readLine();
		int[] alpha = new int[26];

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			alpha[c- 97]++;
		}

		for (int i = 0; i < 26; i++)
			sb.append(alpha[i]).append(' ');

		System.out.println(sb);
		br.close();
	}
}