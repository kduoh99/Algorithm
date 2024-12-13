import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] diff = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			diff[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			diff[i] -= Integer.parseInt(st.nextToken());
		}

		int count = 0;
		boolean flag = true;

		while (flag) {
			flag = false;

			for (int i = 0; i < N; i++) {
				if (diff[i] == 0) continue;
				
				flag = true;
				int v = diff[i];

				for (int j = i + 1; j <= N; j++) {
					if (j == N || diff[i] * diff[j] <= 0) {
						count += Math.abs(v);

						for (int k = i; k < j; k++) {
							diff[k] -= v;
						}
						i = j - 1;
						break;
					}

					if (Math.abs(diff[j]) < Math.abs(v)) {
						v = diff[j];
					}
				}
			}
		}

		System.out.println(count);
		br.close();
	}
}
