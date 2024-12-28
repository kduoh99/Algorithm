import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		System.out.println(Z(0, 0, (int) Math.pow(2, N)));
		br.close();
	}

	private static int Z(int x, int y, int size) {
		if (size == 1) return 0;

		size /= 2;
		if (r < x + size && c < y + size)
			return Z(x, y, size);
		else if (r < x + size)
			return size * size + Z(x, y + size, size);
		else if (c < y + size)
			return size * size * 2 + Z(x + size, y, size);
		else
			return size * size * 3 + Z(x + size, y + size, size);
	}
}
