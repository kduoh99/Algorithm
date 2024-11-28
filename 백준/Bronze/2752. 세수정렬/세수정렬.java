import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final int SIZE = 3;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int a : arr) {
			sb.append(a).append(' ');
		}

		System.out.println(sb);
		br.close();
	}
}
