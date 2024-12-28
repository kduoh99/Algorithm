import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		while (true) {
			int cnt = 0;
			String str = br.readLine().toLowerCase();
			if (str.equals("#")) break;

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
					cnt++;
			}
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}
}
