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
		int[] score = new int[80];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int sum = 0;

			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'O') {
					score[j] = 1;

					if (j > 0 && str.charAt(j - 1) == 'O')
						score[j] = score[j - 1] + 1;
					sum += score[j];
				} else {
					score[j] = 0;
				}
			}
			bw.write(sum + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}