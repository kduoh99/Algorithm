import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		List<Integer> arr = new ArrayList<>();
		List<Integer> diff = new ArrayList<>();

		for (int i = 0; i < N; i++)
			arr.add(Integer.parseInt(st.nextToken()));

		for (int i = 0; i < N - 1; i++)
			diff.add(arr.get(i + 1) - arr.get(i));

		Collections.sort(diff);
		int ans = 0;
		
		for (int i = 0; i < N - K; i++)
			ans += diff.get(i);

		System.out.print(ans);
		br.close();
	}
}