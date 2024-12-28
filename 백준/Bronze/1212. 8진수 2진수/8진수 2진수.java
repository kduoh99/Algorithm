import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			String b = Integer.toBinaryString(str.charAt(i) - '0');

			if (i != 0) {
				while (b.length() < 3)
					b = "0" + b;
			}
			sb.append(b);
		}

		System.out.println(sb);
		br.close();
	}
}
