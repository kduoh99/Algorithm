import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine());
		int r = 31;
		int M = 1234567891;

		String s = br.readLine();
		char[] C = s.toCharArray();

		long ans = 0;
		long pow = 1;
		
		for (int i = 0; i < L; i++) {
			byte A = (byte) C[i];
			ans += (A - 96) * pow;
			pow = (pow * r) % M;
		}
		
		System.out.print(ans % M);
		br.close();
	}
}
