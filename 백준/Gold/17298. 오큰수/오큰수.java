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
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && A[stack.peek()] < A[i])
				A[stack.pop()] = A[i];
			stack.push(i);
		}

		while (!stack.isEmpty())
			A[stack.pop()] = -1;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++)
			sb.append(A[i]).append(' ');

		System.out.println(sb);
		br.close();
	}
}