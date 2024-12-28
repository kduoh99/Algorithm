import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		List<Integer> schedule = new ArrayList<>();
		for (int i = 0; i < K; i++)
			schedule.add(Integer.parseInt(st.nextToken()));

		List<Integer> multiTap = new ArrayList<>();
		int ans = 0;

		for (int i = 0; i < K; i++) {
			int device = schedule.get(i);
			if (multiTap.contains(device)) continue;

			if (multiTap.size() < N) {
				multiTap.add(device);
			} else {
				int lastIdx = -1, toRemove = 0;

				for (int j = 0; j < multiTap.size(); j++) {
					int nextIdx = -1;

					for (int k = i + 1; k < K; k++) {
						if (schedule.get(k).equals(multiTap.get(j))) {
							nextIdx = k;
							break;
						}
					}
					if (nextIdx == -1) {
						toRemove = j;
						break;
					}
					if (nextIdx > lastIdx) {
						lastIdx = nextIdx;
						toRemove = j;
					}
				}
				multiTap.remove(toRemove);
				multiTap.add(device);
				ans++;
			}
		}

		System.out.println(ans);
		br.close();
	}
}
