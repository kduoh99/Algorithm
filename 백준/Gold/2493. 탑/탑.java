import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		var st = new StringTokenizer(br.readLine());
		var stack = new ArrayDeque<int[]>();
		
		for (int i = 0; i < N; i++) {
			int idx = 0;
			int hei = Integer.parseInt(st.nextToken());
			
			while (stack.size() > 0) {
				if (stack.peek()[1] > hei) {
					idx = stack.peek()[0];
					break;
				}
				stack.pop();
			}
			sb.append(idx).append(' ');
			stack.push(new int[] {i + 1, hei});
		}
		System.out.println(sb);
		br.close();
	}
}