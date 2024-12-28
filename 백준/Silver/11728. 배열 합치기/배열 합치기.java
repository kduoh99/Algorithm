import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		int[] B = new int[M];
		ArrayList<Integer> ans = new ArrayList<>();

		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			ans.add(A[i]);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
			ans.add(B[i]);
		}

		Collections.sort(ans);
		StringBuilder sb = new StringBuilder();
		for (int i : ans)
			sb.append(i).append(' ');

		System.out.println(sb);
		br.close();
	}
}
