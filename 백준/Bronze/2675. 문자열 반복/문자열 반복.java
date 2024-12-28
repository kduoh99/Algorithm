import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringBuilder P = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();

			for (int j = 0; j < S.length(); ++j) {
				P.append(String.valueOf(S.charAt(j)).repeat(Math.max(0, R)));
			}
			bw.write(P + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
