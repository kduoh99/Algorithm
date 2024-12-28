import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		char[] ch = br.readLine().toCharArray();

		for (char c : ch) {
			if (c >= 'a' && c <= 'z') {
				sb.append(Character.toUpperCase(c));
			} else {
				sb.append(Character.toLowerCase(c));
			}
		}

		System.out.println(sb);
		br.close();
	}
}