import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if (Math.abs(o1) > Math.abs(o2))
				return 1;
			else if (Math.abs(o1) == Math.abs(o2))
				return o1 - o2;
			else
				return -1;
		});

		while (N-- > 0) {
			int X = Integer.parseInt(br.readLine());

			if (X == 0)
				sb.append(pq.isEmpty() ? 0 : pq.remove()).append('\n');
			else
				pq.offer(X);
		}
		System.out.println(sb);
		br.close();
	}
}