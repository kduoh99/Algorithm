import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashMap<String, int[]> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int len = str.length();
			if (len < M) continue;

			if (!map.containsKey(str)) {
				map.put(str, new int[] {len, 1});
			} else {
				int[] cur = map.get(str);
				cur[1] += 1;
				map.put(str, cur);
			}
		}

		List<String> keySet = new ArrayList<>(map.keySet());

		keySet.sort((o1, o2) -> {
			if (map.get(o2)[1] != map.get(o1)[1]) {
				return map.get(o2)[1] - map.get(o1)[1];
			} else {
				if (map.get(o2)[0] != map.get(o1)[0]) {
					return map.get(o2)[0] - map.get(o1)[0];
				} else {
					return o1.compareTo(o2);
				}
			}
		});

		StringBuilder sb = new StringBuilder();
		for (String key : keySet) {
			sb.append(key).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}
