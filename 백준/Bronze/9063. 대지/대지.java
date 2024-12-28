import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] x = new int[N];
		int[] y = new int[N];
		int maxX = Integer.MIN_VALUE;
		int minX = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			x[i] = Integer.parseInt(input[0]);
			y[i] = Integer.parseInt(input[1]);

			maxX = Math.max(maxX, x[i]);
			minX = Math.min(minX, x[i]);
			maxY = Math.max(maxY, y[i]);
			minY = Math.min(minY, y[i]);
		}
		
		System.out.println((maxX - minX) * (maxY - minY));
		br.close();
	}
}