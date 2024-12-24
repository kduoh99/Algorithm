import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static final StringBuilder sb = new StringBuilder();
	private static int K = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> stack1 = new ArrayDeque<>();
		Deque<Integer> stack2 = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			stack1.push(Integer.parseInt(st.nextToken()));
		}

		int[] disk = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			disk[i] = 1;
		}

		do {
			if (disk[N] == 1) {
				while (stack1.peek() != N) {
					int v = stack1.pop();
					stack2.push(v);
					disk[v] = 2;
					move(1, 2);
				}
				stack1.pop();
				move(1, 3);
			} else if (disk[N] == 2) {
				while (stack2.peek() != N) {
					int v = stack2.pop();
					stack1.push(v);
					disk[v] = 1;
					move(2, 1);
				}
				stack2.pop();
				move(2, 3);
			}
		} while (N-- > 0);

		System.out.println(K);
		System.out.println(sb);
		br.close();
	}

	private static void move(int A, int B) {
		sb.append(A).append(' ').append(B).append('\n');
		K++;
	}
}
