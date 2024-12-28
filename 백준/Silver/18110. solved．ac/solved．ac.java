import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		Arrays.sort(arr);
		int tm = (int) Math.round(N * 0.15);
		int sum = 0, cnt = 0;

		for (int i = tm; i < N - tm; i++) {
			sum += arr[i];
			cnt++;
		}
		
		System.out.println((int) Math.round(sum / (double) cnt));
		br.close();
	}
}