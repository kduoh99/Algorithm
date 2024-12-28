import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int A = 0, B = 0, C = 0;

		if (T % 10 == 0) {
			A = T / 300;
			B = (T % 300) / 60;
			C = (T % 60) / 10;
			sb.append(A).append(' ').append(B).append(' ').append(C).append(' ');
		}
		else
			sb.append(-1);
		
		System.out.println(sb);
		br.close();
	}
}