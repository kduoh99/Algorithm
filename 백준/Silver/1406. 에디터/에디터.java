import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Character> leftStack = new ArrayDeque<>();
		Deque<Character> rightStack = new ArrayDeque<>();
		char[] ch = br.readLine().toCharArray();

		for (char c : ch)
			leftStack.push(c);

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char op = st.nextToken().charAt(0);

			switch(op) {
				case 'L':
					if (!leftStack.isEmpty())
						rightStack.push(leftStack.pop());
					break;
				case 'D':
					if (!rightStack.isEmpty())
						leftStack.push(rightStack.pop());
					break;
				case 'B':
					if (!leftStack.isEmpty())
						leftStack.pop();
					break;
				case 'P':
					char c = st.nextToken().charAt(0);
					leftStack.push(c);
					break;
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!leftStack.isEmpty())
			sb.append(leftStack.pop());

		sb.reverse();
		while (!rightStack.isEmpty())
			sb.append(rightStack.pop());
		
		System.out.println(sb);
		br.close();
	}
}
