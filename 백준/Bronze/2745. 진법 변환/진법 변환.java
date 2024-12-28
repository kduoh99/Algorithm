import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String N = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		int num, exp = 0, sum = 0;

		for (int i = N.length() - 1; i >= 0; i--) {
			char ch = N.charAt(i);

			if (ch >= '0' && ch <= '9') {
				num = ch - '0';
			} else {
				num = ch - 55;
			}
			sum += num * Math.pow(B, exp++);
		}
		
		System.out.println(sum);
		br.close();
	}
}