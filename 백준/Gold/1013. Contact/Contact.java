import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final String REGEX = "(100+1+|01)+";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String str = br.readLine();
			sb.append(str.matches(REGEX) ? "YES" : "NO").append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}
