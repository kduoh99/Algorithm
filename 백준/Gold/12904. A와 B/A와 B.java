import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String T = br.readLine();
		int len = T.length();

		while (S.length() < len) {
			char last = T.charAt(len - 1);

			if (last == 'A')
				T = T.substring(0, len - 1);

			else if (last == 'B') {
				T = T.substring(0, len - 1);
				StringBuilder sb = new StringBuilder(T);
				T = sb.reverse().toString();
			}
			len--;
		}

		System.out.println(S.equals(T) ? "1" : "0");
		br.close();
	}
}
