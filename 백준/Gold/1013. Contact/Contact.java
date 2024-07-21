import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static final String REGEX = "(100+1+|01)+";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			sb.append(str.matches(REGEX) ? "YES" : "NO").append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}