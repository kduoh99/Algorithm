import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[26];
		String str = br.readLine().toUpperCase();

		for (int i = 0; i < str.length(); ++i) {
			if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
				++arr[str.charAt(i) - 65];
		}

		int max = 0;
		char ch = '?';
		for (int i = 0; i < 26; ++i) {
			if (max < arr[i]) {
				max = arr[i];
				ch = (char) (i + 65);
			} else if (max == arr[i]) {
				ch = '?';
			}
		}

		System.out.println(ch);
		br.close();
	}
}
