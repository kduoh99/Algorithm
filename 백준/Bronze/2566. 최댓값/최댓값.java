import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static final int SIZE = 9;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[][] arr = new int[SIZE][SIZE];
		int max = 0, idxI = 0, idxJ = 0;

		for (int i = 0; i < SIZE; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < SIZE; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);

				if (max == arr[i][j]) {
					idxI = i + 1;
					idxJ = j + 1;
				}
			}
		}

		bw.write(max + "\n" + idxI + " " + idxJ + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
