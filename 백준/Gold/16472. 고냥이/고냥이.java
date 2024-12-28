import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[] S = br.readLine().toCharArray();

		int[] alpha = new int[26];
		int start = 0, end = 0, ans = 0, search = 0;

		while (end < S.length) {
			if (alpha[S[end] - 'a'] == 0) {
				search++;
			}
			alpha[S[end] - 'a']++;
			end++;

			while (search > N) {
				alpha[S[start] - 'a']--;
				if (alpha[S[start] - 'a'] == 0) {
					search--;
				}
				start++;
			}

			ans = Math.max(ans, end - start);
		}

		System.out.println(ans);
		br.close();
	}
}
