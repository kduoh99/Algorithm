import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int cnt = 0;
		String s = br.readLine();
		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			int num = s.charAt(i) - '0';

			while (!stack.isEmpty() && cnt < K && stack.peek() < num) {
				stack.pop();
				cnt++;
			}
			stack.push(num);
		}

		while (cnt < K && !stack.isEmpty()) {
			stack.pop();
			cnt++;
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());

		System.out.println(sb.reverse());
		br.close();
	}
}