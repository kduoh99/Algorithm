import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<int[]> list = new ArrayList<>();

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int h1 = Integer.parseInt(st.nextToken());
			int h2 = Integer.parseInt(st.nextToken());
			list.add(new int[] {h1, i});
			list.add(new int[] {h2, i});
		}

		list.sort(Comparator.comparingInt(o -> o[0]));

		while (N-- > 1) {
			list.add(list.remove(0));
		}

		System.out.println(list.get(0)[1]);
		br.close();
	}
}
