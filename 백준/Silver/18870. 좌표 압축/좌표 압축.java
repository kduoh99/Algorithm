import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int[] sorted = arr.clone();
		Arrays.sort(sorted);

		Map<Integer, Integer> rMap = new HashMap<>();
		int rank = 0;

		for (int j : sorted) {
			if (!rMap.containsKey(j))
				rMap.put(j, rank++);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++)
			sb.append(rMap.get(arr[i])).append(" ");

		System.out.println(sb);
		br.close();
	}
}
