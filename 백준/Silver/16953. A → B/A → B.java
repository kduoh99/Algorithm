import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int ans = 1;

		while (B > A) {
			if (B % 2 == 0)
				B /= 2;
			else if (B % 10 == 1)
				B /= 10;
			else
				break;

			ans++;
		}

		System.out.println(B != A ? "-1" : ans);
		br.close();
	}
}