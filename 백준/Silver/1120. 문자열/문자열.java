import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String X = st.nextToken();
		String Y = st.nextToken();

		int result = 50;
		for (int i = 0; i <= Y.length() - X.length(); i++) {
			int tmp = 0;
			for (int j = 0; j < X.length(); j++) {
				if (X.charAt(j) != Y.charAt(j + i)) {
					tmp++;
				}
			}
			result = Math.min(result, tmp);
		}

		System.out.println(result);
		br.close();
	}
}
