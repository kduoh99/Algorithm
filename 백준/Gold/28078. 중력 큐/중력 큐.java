import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		Deque<Character> q = new ArrayDeque<>();
		int dir = 0, ball = 0, wall = 0;
		int Q = Integer.parseInt(br.readLine());

		for (int i = 0; i < Q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();

			switch (op) {
				case "push": {
					char type = st.nextToken().charAt(0);
					if (type == 'w') {
						q.offerLast(type);
						wall++;
					} else if (dir == 1) {
						if (!q.isEmpty() && q.peekFirst() == 'w') {
							q.offerLast(type);
							ball++;
						}
					} else if (dir == 0 || dir == 2) {
						q.offerLast(type);
						ball++;
					}
					break;
				}
				case "pop": {
					if (!q.isEmpty()) {
						if (q.pollFirst() == 'w') {
							wall--;
						} else {
							ball--;
						}
					}

					if (dir == 1) {
						while (!q.isEmpty() && q.peekFirst() == 'b') {
							q.pollFirst();
							ball--;
						}
					}
					break;
				}
				case "rotate": {
					String turn = st.nextToken();
					dir = turn.equals("l") ? (dir + 3) % 4 : (dir + 1) % 4;

					if (dir == 1) {
						while (!q.isEmpty() && q.peekFirst() == 'b') {
							q.pollFirst();
							ball--;
						}
					} else if (dir == 3) {
						while (!q.isEmpty() && q.peekLast() == 'b') {
							q.pollLast();
							ball--;
						}
					}
					break;
				}
				case "count": {
					char type = st.nextToken().charAt(0);
					sb.append(type == 'b' ? ball : wall).append('\n');
					break;
				}
			}
		}

		System.out.println(sb);
		br.close();
	}
}
