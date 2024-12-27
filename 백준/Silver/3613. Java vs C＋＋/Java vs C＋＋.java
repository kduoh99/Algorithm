import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] ch = br.readLine().toCharArray();
		int len = ch.length;

		if (!isValid(ch)) {
			System.out.println("Error!");
			return;
		}

		boolean isCpp = false, isJava = false;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < len; i++) {
			char c = ch[i];

			if (c == '_') {
				if (i + 1 < len && Character.isLowerCase(ch[i + 1])) {
					sb.append(Character.toUpperCase(ch[++i]));
					isCpp = true;
				} else {
					System.out.println("Error!");
					return;
				}
			} else if (Character.isUpperCase(c)) {
				sb.append('_').append(Character.toLowerCase(c));
				isJava = true;
			} else {
				sb.append(c);
			}
		}

		System.out.println(isCpp && isJava ? "Error!" : sb);
		br.close();
	}

	private static boolean isValid(char[] ch) {
		if (Character.isUpperCase(ch[0]) || ch[0] == '_' || ch[ch.length - 1] == '_') {
			return false;
		}

		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '_' && (i + 1 < ch.length && ch[i + 1] == '_')) {
				return false;
			}

			if (!Character.isLowerCase(ch[i]) && ch[i] != '_' && !Character.isUpperCase(ch[i])) {
				return false;
			}
		}
		return true;
	}
}
