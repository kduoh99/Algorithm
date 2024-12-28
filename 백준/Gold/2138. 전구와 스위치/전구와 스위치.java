import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[] curBulbs = br.readLine().toCharArray();
		char[] targetBulbs = br.readLine().toCharArray();

		int cnt1 = countSwitch(curBulbs.clone(), targetBulbs, N, false);
		int cnt2 = countSwitch(curBulbs.clone(), targetBulbs, N, true);

		int result = 0;
		if (cnt1 == -1) {
			result = cnt2;
		} else if (cnt2 == -1) {
			result = cnt1;
		} else {
			result = Math.min(cnt1, cnt2);
		}

		System.out.println(result);
		br.close();
	}

	private static int countSwitch(char[] cur, char[] target, int N, boolean flag) {
		int cnt = 0;
		if (flag) {
			flip(cur, 0);
			cnt++;
		}
		for (int i = 1; i < N; i++) {
			if (cur[i - 1] != target[i - 1]) {
				flip(cur, i);
				cnt++;
			}
		}
		if (cur[N - 1] != target[N - 1]) {
			return -1;
		}
		return cnt;
	}

	private static void flip(char[] cur, int idx) {
		for (int i = idx - 1; i <= idx + 1; i++) {
			if (i >= 0 && i < cur.length) {
				cur[i] = cur[i] == '0' ? '1' : '0';
			}
		}
	}
}
