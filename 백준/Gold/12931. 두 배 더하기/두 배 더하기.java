import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] B = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++)
			B[i] = Integer.parseInt(st.nextToken());

		int maxDiv = 0, dec = 0;
		for (int i = 0; i < N; i++) {
			int tmp = 0;

			while (B[i] > 0) {
				if (B[i] % 2 != 0) {
					B[i] = --B[i];
					dec++;
				} else {
					B[i] /= 2;
					tmp++;
				}
			}
			maxDiv = Math.max(maxDiv, tmp);
		}

		System.out.println(maxDiv + dec);
		br.close();
	}
}
