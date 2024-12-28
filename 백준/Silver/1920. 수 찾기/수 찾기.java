import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(A);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int b = Integer.parseInt(st.nextToken());
			sb.append(Arrays.binarySearch(A, b) >= 0 ? 1 : 0).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}