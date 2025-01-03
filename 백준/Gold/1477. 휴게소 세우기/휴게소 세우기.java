import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static List<Integer> list;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		list.add(0);
		list.add(L);

		if (N > 0) {
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
		}

		Collections.sort(list);
		System.out.println(binarySearch(1, L - 1));
		br.close();
	}

	private static int binarySearch(int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;

			for (int i = 1; i < list.size(); i++) {
				cnt += (list.get(i) - list.get(i - 1) - 1) / mid;
			}

			if (cnt > M) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return left;
	}
}

