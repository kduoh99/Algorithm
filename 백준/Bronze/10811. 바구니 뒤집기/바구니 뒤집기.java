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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] basket = new int[N];
		
		for (int k = 0; k < N; ++k) {
			basket[k] = k + 1;
		}

		int i, j, item;
		for (int k = 0; k < M; ++k) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken()) - 1;
			j = Integer.parseInt(st.nextToken()) - 1;

			while (true) {
				if (i >= j) break;
				item = basket[i];
				basket[i] = basket[j];
				basket[j] = item;
				++i;
				--j;
			}
		}
		
		for (int k = 0; k < N; ++k) {
			bw.write(basket[k] + " ");
		}
		
		bw.write("\n");
		bw.flush();
		br.close();
		bw.close();
	}
}