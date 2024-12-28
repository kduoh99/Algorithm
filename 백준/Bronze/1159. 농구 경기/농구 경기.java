import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] alpha = new int[26];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			alpha[str.charAt(0) - 97]++;
		}

		boolean flag = false;
		for (int i = 0; i < 26; i++) {
			if (alpha[i] >= 5) {
				flag = true;
				sb.append((char) (i + 97));
			}
		}

		System.out.println(flag ? sb : "PREDAJA");
		br.close();
	}
}
