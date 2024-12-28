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
		Deque<Integer> stack = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int order = 1;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (num == order) {
				order++;
			} else {
				stack.push(num);
			}
			
			while (!stack.isEmpty() && stack.peek() == order) {
				stack.pop();
				order++;
			}
		}
		
		System.out.println(stack.isEmpty() ? "Nice" : "Sad");
		br.close();
	}
}
