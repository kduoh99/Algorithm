import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];

		for (int i = 1 ; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		long result = 0;

		for (int i = 1; i <= N; i++) {
			result += Math.abs(arr[i] - i);
		}

		System.out.println(result);
		br.close();
	}
}