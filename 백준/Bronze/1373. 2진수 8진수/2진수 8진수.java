import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int len = str.length();
		int start = 0, end = len % 3 == 0 ? 3 : len % 3;

		while (start < len) {
			String B = str.substring(start, end);
			int O = Integer.parseInt(B, 2);

			sb.append(O);
			start = end;
			end += 3;
		}

		System.out.println(sb);
		br.close();
	}
}
