import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] ch = br.readLine().toCharArray();
		int open = 0, close = 0, balance = 0, answer = 0;

		for (char c : ch) {
			if (c == '(') {
				open++;
				balance++;
			} else {
				close++;
				balance--;
			}

			if (balance == 1)
				open = 0;

			if (balance == -1) {
				answer = close;
				break;
			}
		}

		if (balance == 2)
			answer = open;

		System.out.println(answer);
		br.close();
	}
}
