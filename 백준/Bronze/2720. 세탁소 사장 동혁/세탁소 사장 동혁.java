import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int C = Integer.parseInt(br.readLine());
			sb.append(C / 25).append(" ")
				.append(C % 25 / 10).append(" ")
				.append(C % 25 % 10 / 5).append(" ")
				.append(C % 25 % 10 % 5 / 1).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}