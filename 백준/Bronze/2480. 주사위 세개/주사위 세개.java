import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int d1 = Integer.parseInt(st.nextToken());
		int d2 = Integer.parseInt(st.nextToken());
		int d3 = Integer.parseInt(st.nextToken());
		int reward;

		if (d1 != d2 && d1 != d3 && d2 != d3) {
			reward = Math.max(d1, Math.max(d2, d3)) * 100;
		} else if (d1 == d2 && d1 == d3) {
			reward = 10000 + (d1 * 1000);
		} else if (d1 == d2 || d1 == d3) {
			reward = 1000 + (d1 * 100);
		} else {
			reward = 1000 + (d2 * 100);
		}

		bw.write(reward + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
