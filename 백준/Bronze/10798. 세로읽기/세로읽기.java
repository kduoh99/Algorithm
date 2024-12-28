import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] st = new char[5][15];
		int max = 0;

		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			max = Math.max(max, str.length());

			for (int j = 0; j < str.length(); j++) {
				st[i][j] = str.charAt(j);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < 5; j++) {
				if (st[j][i] == '\0') continue;
				sb.append(st[j][i]);
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
