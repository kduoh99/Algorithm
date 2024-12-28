import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		String S = br.readLine();

		for (int i = 0; i < S.length(); i++) {
			int a = S.charAt(i);

			if (a >= 65 && a <= 90) {
				a += 13;

				if (a > 90)
					a -= 26;
			} else if (a >= 97 && a <= 122) {
				a += 13;

				if (a > 122)
					a -= 26;
			}

			sb.append((char)a);
		}

		System.out.println(sb);
		br.close();
	}
}