import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<int[]> points = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points.add(new int[] {x, y});
		}

		points.sort(Comparator.comparingInt(a -> a[0]));
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(0);

		for (int i = 1; i < N; i++) {
			while (!stack.isEmpty()) {
				if (points.get(stack.peek())[1] < points.get(i)[1]) {
					stack.pop();
				} else {
					break;
				}
			}
			stack.push(i);
		}

		long answer = 0L;
		int prev = stack.pollLast();
		answer += (long)points.get(prev)[0] * points.get(prev)[1];

		while (!stack.isEmpty()) {
			int cur = stack.pollLast();
			answer += (long)(points.get(cur)[0] - points.get(prev)[0]) * points.get(cur)[1];
			prev = cur;
		}

		System.out.println(answer);
		br.close();
	}
}
