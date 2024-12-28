import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] LIS;
	private static int[][] wires;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		wires = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			wires[i][0] = Integer.parseInt(st.nextToken());
			wires[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(wires, Comparator.comparingInt(o -> o[0]));
		LIS = new int[N];
		Arrays.fill(LIS, 1);
		cal();

		int max = 0;
		for (int i = 0; i < N; i++)
			max = Math.max(max, LIS[i]);

		int ans = N - max;
		System.out.println(ans);
		br.close();
	}

	private static void cal() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (wires[j][1] < wires[i][1] && LIS[i] < LIS[j] + 1)
					LIS[i] = LIS[j] + 1;
			}
		}
	}
}