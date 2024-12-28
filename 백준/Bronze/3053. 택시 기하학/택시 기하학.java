import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int R = Integer.parseInt(br.readLine());
		double A = Math.PI * Math.pow(R, 2);
		double B = 2 * Math.pow(R, 2);

		sb.append(String.format("%.6f", A)).append('\n')
			.append(String.format("%.6f", B));

		System.out.println(sb);
		br.close();
	}
}