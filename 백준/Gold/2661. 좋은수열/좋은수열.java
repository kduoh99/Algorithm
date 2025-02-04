import java.io.*;

public class Main {
	private static int N;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		backtracking(0);
	}

	private static void backtracking(int depth) {
		if (depth == N) {
			StringBuilder sb = new StringBuilder();
			for (int a : arr) {
				sb.append(a);
			}
			System.out.println(sb);
			System.exit(0);
		}

		for (int i = 1; i <= 3; i++) {
			arr[depth] = i;
			if (check(depth)) backtracking(depth + 1);
		}
	}

	private static boolean check(int len) {
		for (int i = 1; i <= (len + 1) / 2; i++) {
			boolean flag = true;

			for (int j = 0; j < i; j++) {
				if (arr[len - j] != arr[len - j - i]) {
					flag = false;
					break;
				}
			}
			if (flag) return false;
		}
		return true;
	}
}
