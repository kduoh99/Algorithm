import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			String[] S = br.readLine().split(" ");

			for (String s : S) {
				StringBuilder sb1 = new StringBuilder(s);
				sb.append(sb1.reverse()).append(" ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}
}