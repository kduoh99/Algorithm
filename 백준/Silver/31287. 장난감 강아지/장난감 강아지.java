import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int K = Integer.parseInt(in[1]);

		String S = br.readLine();
		int x = 0, y = 0;

		if (K > (N >> 1))
			K = (N >> 1);

		while (K-- > 0) {
			for (char c : S.toCharArray()) {
				switch (c) {
					case 'U':
						y++;
						break;
					case 'D':
						y--;
						break;
					case 'L':
						x--;
						break;
					case 'R':
						x++;
						break;
				}

				if (x == 0 && y == 0) {
					System.out.println("YES");
					return;
				}
			}
		}

		System.out.println("NO");
		br.close();
	}
}
