import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int x, y;
		int result = 0;
		boolean[][] paper = new boolean[100][100];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			x = Integer.parseInt(input[0]);
			y = Integer.parseInt(input[1]);

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					if (!paper[j][k]) {
						paper[j][k] = true;
						result++;
					}
				}
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}