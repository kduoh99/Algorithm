import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			int x = Integer.parseInt(br.readLine());

			if (x == 0)
				sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
			else
				pq.offer(x);
		}

		System.out.println(sb);
		br.close();
	}
}