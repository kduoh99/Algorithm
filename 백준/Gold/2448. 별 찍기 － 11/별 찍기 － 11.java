import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static String[] star;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		star = new String[N];
		star[0] = "  *  ";
		star[1] = " * * ";
		star[2] = "*****";

		for (int k = 1; 3 * (int) Math.pow(2, k) <= N; k++)
			draw(k);

		for (int i = 0; i < N; i++)
			sb.append(star[i]).append('\n');

		System.out.println(sb);
		br.close();
	}

	private static void draw(int k) {
		int bottom = 3 * (int) Math.pow(2, k);
		int middle = bottom / 2;

		for (int i = middle; i < bottom; i++)
			star[i] = star[i - middle] + " " + star[i - middle];

		StringBuilder sb = new StringBuilder();
		while (sb.length() < middle)
			sb.append(" ");

		for (int i = 0; i < middle; i++)
			star[i] = sb + star[i] + sb;
	}
}