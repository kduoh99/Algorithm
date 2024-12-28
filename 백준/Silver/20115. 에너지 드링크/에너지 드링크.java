import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (max < arr[i])
				max = arr[i];
		}

		double ans = max;
		for (int i = 0; i < N; i++) {
			if (max != arr[i])
				ans += arr[i] / 2.0;
		}
		
		System.out.println(ans);
		br.close();
	}
}