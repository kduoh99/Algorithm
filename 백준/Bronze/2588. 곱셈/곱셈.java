import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int num1 = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());

		sb.append(num1 * (num2 % 10)).append('\n')
			.append(num1 * (num2 / 10 % 10)).append('\n')
			.append(num1 * (num2 / 100)).append('\n')
			.append(num1 * num2);

		System.out.println(sb);
		br.close();
	}
}