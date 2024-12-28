import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[] ch = br.readLine().toCharArray();
		double[] val = new double[N];
		
		for (int i = 0; i < N; i++)
			val[i] = Double.parseDouble(br.readLine());

		Deque<Double> stack = new ArrayDeque<>();
		for (char c : ch) {
			if (c >= 'A' && c <= 'Z') {
				stack.push(val[c - 'A']);
			} else {
				if (!stack.isEmpty()) {
					double b = stack.pop();
					double a = stack.pop();

					switch (c) {
						case '+':
							stack.push(a + b);
							break;
						case '-':
							stack.push(a - b);
							break;
						case '*':
							stack.push(a * b);
							break;
						case '/':
							stack.push(a / b);
							break;
					}
				}
			}
		}

		System.out.printf("%.2f", stack.pop());
		br.close();
	}
}
