import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] sensor = new int[N];

		for (int i = 0; i < N; i++)
			sensor[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(sensor);
		Integer[] diff = new Integer[N - 1];

		for (int i = 1; i < N; i++)
			diff[i - 1] = sensor[i] - sensor[i - 1];

		Arrays.sort(diff, Collections.reverseOrder());
		int ans = 0;

		for (int i = K - 1; i < N - 1; i++)
			ans += diff[i];

		System.out.println(ans);
		br.close();
	}
}