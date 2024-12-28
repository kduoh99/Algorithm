import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Deque<Integer> trucks = new ArrayDeque<>();
		while (n-- > 0) {
			int a = Integer.parseInt(st.nextToken());
			trucks.offer(a);
		}

		Deque<Integer> bridge = new ArrayDeque<>();
		for (int i = 0; i < w; i++)
			bridge.offer(0);

		int time = 0, curW = 0;
		while (!trucks.isEmpty()) {
			curW -= bridge.poll();

			if (curW + trucks.peek() <= L) {
				int truckW = trucks.poll();
				bridge.offer(truckW);
				curW += truckW;
			} else {
				bridge.offer(0);
			}
			time++;
		}

		System.out.println(time + w);
		br.close();
	}
}
