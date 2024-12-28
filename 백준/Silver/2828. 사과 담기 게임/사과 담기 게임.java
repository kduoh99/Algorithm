import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int J = Integer.parseInt(br.readLine());

		int move = 0, start = 1, end = M;
		for (int i = 0; i < J; i++) {
			int idx = Integer.parseInt(br.readLine());

			if (start > idx) {
				move += start - idx;
				end -= start - idx;
				start = idx;
			} else if (end < idx) {
				move += idx - end;
				start += idx - end;
				end = idx;
			}
		}

		System.out.println(move);
		br.close();
	}
}
