import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int ctor = 0;

		for(int i = 0; i < N; i++) {
			int num = i;
			int dSum = 0;

			while (num != 0) {
				dSum += num % 10;
				num /= 10;
			}
			
			if(dSum + i == N) {
				ctor = i;
				break;
			}
		}
		
		System.out.println(ctor);
		br.close();
	}
}