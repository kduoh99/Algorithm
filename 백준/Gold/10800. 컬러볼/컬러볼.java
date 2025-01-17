import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Ball[] balls = new Ball[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			balls[i] = new Ball(i, c, s);
		}

		Arrays.sort(balls, Comparator.comparingInt(o -> o.size));
		int[] colorSum = new int[N + 1];
		int totalSum = 0, idx = 0;

		for (int i = 0; i < N; i++) {
			while (idx < N && balls[idx].size < balls[i].size) {
				totalSum += balls[idx].size;
				colorSum[balls[idx].color] += balls[idx].size;
				idx++;
			}
			balls[i].sum = totalSum - colorSum[balls[i].color];
		}

		Arrays.sort(balls, Comparator.comparingInt(o -> o.idx));
		StringBuilder sb = new StringBuilder();

		for (Ball ball : balls) {
			sb.append(ball.sum).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}

class Ball {
	int idx, color, size, sum;

	public Ball(int idx, int color, int size) {
		this.idx = idx;
		this.color = color;
		this.size = size;
	}
}
