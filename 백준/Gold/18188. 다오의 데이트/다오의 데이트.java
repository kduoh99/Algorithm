import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {1, -1, 0, 0};
	private static final List<char[]> cmd = new ArrayList<>();

	private static int H, W, startX, startY;
	private static char[][] arr;
	private static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new char[H][W];

		for (int i = 0; i < H; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			cmd.add(br.readLine().replace(" ", "").toCharArray());
		}

		searchD();
		dfs(0, startX, startY, new StringBuilder());
		if (!flag) System.out.println("NO");
		br.close();
	}

	private static void searchD() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (arr[i][j] == 'D') {
					startX = i;
					startY = j;
					return;
				}
			}
		}
	}

	private static int getDir(char dir) {
		switch (dir) {
			case 'W': return 2;
			case 'S': return 3;
			case 'A': return 1;
			case 'D': return 0;
		}
		return -1;
	}

	private static void dfs(int step, int x, int y, StringBuilder sb) {
		if (flag || step == cmd.size()) return;

		for (char dir : cmd.get(step)) {
			int d = getDir(dir);
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && nx < H && ny >= 0 && ny < W && arr[nx][ny] != '@') {
				sb.append(dir);

				if (arr[nx][ny] == 'Z') {
					System.out.println("YES\n" + sb);
					flag = true;
					return;
				}

				dfs(step + 1, nx, ny, sb);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
}
