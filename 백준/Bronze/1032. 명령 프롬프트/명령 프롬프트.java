import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] S = new String[N];

		for (int i = 0; i < N; i++)
			S[i] = br.readLine();

		for (int i = 0; i < S[0].length(); i++) {
			boolean flag = true;

			for (int j = 1; j < N; j++) {
				if (S[0].charAt(i) != S[j].charAt(i)) {
					flag = false;
					break;
				}
			}
			sb.append(flag ? S[0].charAt(i) : "?");
		}

		System.out.println(sb);
		br.close();
	}
}
