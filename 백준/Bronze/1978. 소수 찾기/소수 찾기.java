import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int pn = 0;

		for (int i = 0; i < N; i++) {
			int count = 0;
			int num = Integer.parseInt(st.nextToken());

			for (int j = 2; j <= num; j++) {
				if (num % j == 0)
					count++;
			}
			if (count == 1)
				pn++;
		}
		
		System.out.println(pn);
		br.close();
	}
}