import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static String ball;
	private static int ans = Integer.MAX_VALUE, cnt = 0;
	private static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ball = br.readLine();

		collectBalls(0, N, 'R');
		collectBalls(0, N, 'B');
		collectBalls(N, 0, 'R');
		collectBalls(N, 0, 'B');

		System.out.println(ans);
		br.close();
	}

	private static void collectBalls(int start, int end, char move) {
		cnt = 0;
		flag = false;

		if (start < end) {
			for (int i = start; i < end; i++) {
				if (flag && ball.charAt(i) == move)
					cnt++;

				if (move == 'R') {
					if (ball.charAt(i) == 'B')
						flag = true;
				} else {
					if (ball.charAt(i) == 'R')
						flag = true;
				}
			}
		} else {
			for (int i = start - 1; i >= end; i--) {
				if (flag & ball.charAt(i) == move)
					cnt++;

				if (move == 'B') {
					if (ball.charAt(i) == 'R')
						flag = true;
				} else {
					if (ball.charAt(i) == 'B')
						flag = true;
				}
			}
		}
		ans = Math.min(ans, cnt);
	}
}
