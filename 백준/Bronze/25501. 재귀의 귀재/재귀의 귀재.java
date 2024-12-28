import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			String s = br.readLine();
			sb.append(isPalindrome(s)).append(' ').append(cnt).append('\n');
		}

		System.out.println(sb);
		br.close();
	}

	private static int recursion(String s, int l, int r) {
		if (l >= r)
			return 1;
		else if (s.charAt(l) != s.charAt(r))
			return 0;
		else {
			cnt++;
			return recursion(s, l + 1, r - 1);
		}
	}

	private static int isPalindrome(String s) {
		cnt = 1;
		return recursion(s, 0, s.length() - 1);
	}
}