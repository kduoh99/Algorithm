import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(a);
		int x = Integer.parseInt(br.readLine());
		int i = 0, j = n - 1, sum, cnt = 0;

		while (i < j) {
			sum = a[i] + a[j];

			if (sum < x) {
				i++;
			} else if (sum > x) {
				j--;
			} else {
				i++;
				cnt++;
			}
		}

		System.out.println(cnt);
		br.close();
	}
}
