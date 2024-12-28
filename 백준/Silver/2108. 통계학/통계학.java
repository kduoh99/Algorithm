import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[8001];

		int sum = 0;
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		int median = Integer.MIN_VALUE, mode = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(br.readLine());
			sum += val;
			arr[val + 4000]++;

			if (max < val)
				max = val;
			if (min > val)
				min = val;
		}

		int cnt = 0, larger_mode = 0;
		boolean flag = false;

		for (int i = min + 4000; i <= max + 4000; i++) {
			if (arr[i] > 0) {
				if (cnt < (N + 1) / 2) {
					cnt += arr[i];
					median = i - 4000;
				}

				if (larger_mode < arr[i]) {
					larger_mode = arr[i];
					mode = i - 4000;
					flag = true;
				} else if (larger_mode == arr[i] && flag) {
					mode = i - 4000;
					flag = false;
				}
			}
		}

		sb.append((int)Math.round(sum / (double)N)).append('\n')
			.append(median).append('\n').append(mode).append('\n').append(max - min).append('\n');

		System.out.println(sb);
		br.close();
	}
}