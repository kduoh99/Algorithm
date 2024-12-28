import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] x = new int[4];
		int[] y = new int[4];

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(find(x) + " " + find(y));
		br.close();
	}

	private static int find(int[] f) {
		if (f[0] == f[1]) {
			f[3] = f[2];
		} else if (f[0] == f[2]) {
			f[3] = f[1];
		} else {
			f[3] = f[0];
		}
		return f[3];
	}
}