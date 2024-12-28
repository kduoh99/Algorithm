import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		String S = "";
		
		while ((S = br.readLine()) != null) {
			int L = 0, U = 0, N = 0, B = 0;

			for (int j = 0; j < S.length(); j++) {
				char c = S.charAt(j);

				if (c >= 'a' && c <= 'z')
					L++;
				else if (c >= 'A' && c <= 'Z')
					U++;
				else if (c >= '0' && c <= '9')
					N++;
				else if (c == ' ')
					B++;
			}
			sb.append(L).append(" ").append(U).append(" ").append(N).append(" ").append(B).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}