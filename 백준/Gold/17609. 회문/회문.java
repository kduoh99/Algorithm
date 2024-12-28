import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			char[] str = br.readLine().toCharArray();
			sb.append(isPalindrome(str)).append('\n');
		}

		System.out.println(sb);
		br.close();
	}

	private static int isPalindrome(char[] str) {
		int i = 0, j = str.length - 1;

		while (i < j) {
			if (str[i] == str[j]) {
				i++;
				j--;
			} else {
				if (isPalindrome(str, i + 1, j) == 0) {
					return 1;
				} else if (isPalindrome(str, i, j - 1) == 0) {
					return 1;
				}
				return 2;
			}
		}

		return 0;
	}

	private static int isPalindrome(char[] str, int start, int end) {
		int i = start, j = end;
		while (i < j) {
			if (str[i] != str[j]) {
				return 2;
			}
			i++;
			j--;
		}
		return 0;
	}
}

