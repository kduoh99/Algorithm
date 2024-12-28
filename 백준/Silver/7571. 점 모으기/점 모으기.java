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

		ArrayList<Integer> X = new ArrayList<>();
		ArrayList<Integer> Y = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			X.add(x);
			Y.add(y);
		}

		Collections.sort(X);
		Collections.sort(Y);

		int midX = X.get((M - 1) / 2);
		int midY = Y.get((M - 1) / 2);

		int dist = 0;
		for (int i = 0; i < M; i++)
			dist += Math.abs(midX - X.get(i)) + Math.abs(midY - Y.get(i));

		System.out.println(dist);
		br.close();
	}
}
