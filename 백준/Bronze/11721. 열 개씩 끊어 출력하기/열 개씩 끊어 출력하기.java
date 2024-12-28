import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int len = str.length();

		for (int i = 1; i <= len; i++) {
			if (i / 10 >= 1 && i % 10 == 0) {
				sb.append(str.charAt(i-1)).append("\n");
				continue;
			}
			sb.append(str.charAt(i-1));
		}
		
		System.out.println(sb);
		br.close();
	}
}