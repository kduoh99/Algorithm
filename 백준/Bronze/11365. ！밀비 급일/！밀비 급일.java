import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String st = br.readLine();

			if (st.equals("END")) break;
			int len = st.length();

			for (int i = len - 1; i >= 0; i--) {
				sb.append(st.charAt(i));
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}