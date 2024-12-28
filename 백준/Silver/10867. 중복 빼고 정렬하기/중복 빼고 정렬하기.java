import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> A = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (!A.contains(num)) {
				A.add(num);
			}
		}

		Collections.sort(A);
		StringBuilder sb = new StringBuilder();

		for (int a : A) {
			sb.append(a).append(' ');
		}

		System.out.println(sb);
		br.close();
	}
}