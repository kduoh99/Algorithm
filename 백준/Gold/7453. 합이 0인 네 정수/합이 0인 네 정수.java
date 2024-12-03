import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		int[] B = new int[n];
		int[] C = new int[n];
		int[] D = new int[n];
		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}

		int k = 0;
		int[] AB = new int[n * n];
		int[] CD = new int[n * n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				AB[k] = A[i] + B[j];
				CD[k] = C[i] + D[j];
				k++;
			}
		}

		Arrays.sort(AB);
		Arrays.sort(CD);

		int i = 0, j = n * n - 1;
		long cnt = 0;

		while (i < n * n && j >= 0) {
			int sum = AB[i] + CD[j];

			if (sum == 0) {
				long cntAB = 1, cntCD = 1;

				while (i + 1 < n * n && AB[i] == AB[i + 1]) {
					i++;
					cntAB++;
				}

				while (j - 1 >= 0 && CD[j] == CD[j - 1]) {
					j--;
					cntCD++;
				}

				cnt += cntAB * cntCD;
				i++;
				j--;
			} else if (sum < 0) {
				i++;
			} else {
				j--;
			}
		}

		System.out.println(cnt);
		br.close();
	}
}
