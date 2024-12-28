import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final int SIZE = 10;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0){
			int[] A = new int[SIZE];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < SIZE; j++)
				A[j] = Integer.parseInt(st.nextToken());

			Arrays.sort(A);
			sb.append(A[7]).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}