import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int ans = 0;
		for (int i = 1; i < 9; i++) {
			String str = br.readLine();

			for (int j = 1; j < 9; j++) {
				char c = str.charAt(j - 1);

				if (i % 2 == 1 && j % 2 == 1 && c == 'F') {
					ans++;
				}
				
				if (i % 2 == 0 && j % 2 == 0 && c == 'F') {
					ans++;
				}
			}
		}

		System.out.println(ans);
		br.close();
	}
}
