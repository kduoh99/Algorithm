import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int Q = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> tMap = new TreeMap<>();

			for (int j = 0; j < Q; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char op = st.nextToken().charAt(0);
				int val = Integer.parseInt(st.nextToken());

				if (op == 'I') {
					tMap.put(val, tMap.getOrDefault(val, 0) + 1);
				} else if (op == 'D') {
					if (!tMap.isEmpty()) {
						if (val == -1) {
							int minKey = tMap.firstKey();

							if (tMap.get(minKey) == 1)
								tMap.remove(minKey);
							else
								tMap.put(minKey, tMap.get(minKey) - 1);
						}
						else if (val == 1) {
							int maxKey = tMap.lastKey();

							if (tMap.get(maxKey) == 1)
								tMap.remove(maxKey);
							else
								tMap.put(maxKey, tMap.get(maxKey) - 1);
						}
					}
				}
			}

			if (!tMap.isEmpty())
				sb.append(tMap.lastKey()).append(" ").append(tMap.firstKey()).append('\n');
			else
				sb.append("EMPTY").append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}
