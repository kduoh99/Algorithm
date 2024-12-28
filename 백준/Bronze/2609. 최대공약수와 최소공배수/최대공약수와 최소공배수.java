import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int tmp, mul = a * b;

		while (a % b != 0) {
			tmp = a % b;
			a = b;
			b = tmp;
		}
		
		sb.append(b).append('\n').append(mul / b);
		System.out.println(sb);
		br.close();
	}
}