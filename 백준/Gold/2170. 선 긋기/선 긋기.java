import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Line[] lines = new Line[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			lines[i] = new Line(x, y);
		}

		Arrays.sort(lines, (o1, o2) -> o1.x != o2.x ? o1.x - o2.x : o1.y - o2.y);
		int total = 0, curX = lines[0].x, curY = lines[0].y;

		for (int i = 1; i < N; i++) {
			if (lines[i].x <= curY) {
				curY = Math.max(curY, lines[i].y);
			} else {
				total += (curY - curX);
				curX = lines[i].x;
				curY = lines[i].y;
			}
		}

		total += (curY - curX);
		System.out.println(total);
		br.close();
	}
}

class Line {
	int x, y;

	public Line(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
