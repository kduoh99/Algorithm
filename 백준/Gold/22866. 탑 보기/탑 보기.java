import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] height = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		int[] leftCnt = new int[N + 1];
		int[] leftNear = new int[N + 1];
		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
				stack.pop();
			}

			leftCnt[i] = stack.size();
			leftNear[i] = stack.isEmpty() ? 0 : stack.peek();
			stack.push(i);
		}

		int[] rightCnt = new int[N + 1];
		int[] rightNear = new int[N + 1];
		stack.clear();

		for (int i = N; i >= 1; i--) {
			while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
				stack.pop();
			}

			rightCnt[i] = stack.size();
			rightNear[i] = stack.isEmpty() ? 0 : stack.peek();
			stack.push(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int total = leftCnt[i] + rightCnt[i];

			if (total == 0) {
				sb.append(0);
			} else {
				sb.append(total).append(' ');

				if (leftNear[i] == 0) {
					sb.append(rightNear[i]);
				} else if (rightNear[i] == 0) {
					sb.append(leftNear[i]);
				} else {
					sb.append(i - leftNear[i] <= rightNear[i] - i ? leftNear[i] : rightNear[i]);
				}
			}
			sb.append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}
