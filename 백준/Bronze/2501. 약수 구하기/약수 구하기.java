import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		int[] tmp = new int[N];
		int count = 1;
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				tmp[count] = i;
				count++;
			}
		}
		
		System.out.println(tmp[K]);
		br.close();
	}
}