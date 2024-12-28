import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			String[] P = br.readLine().split(" ");
			int min = Integer.MAX_VALUE;

			if (N > 32) {
				System.out.println(0);
				continue;
			}

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					for (int k = j + 1; k < N; k++) {
						int dist = 0;

						for (int l = 0; l < 4; l++)	{
							dist += P[i].charAt(l) != P[j].charAt(l) ? 1 : 0;
							dist += P[i].charAt(l) != P[k].charAt(l) ? 1 : 0;
							dist += P[j].charAt(l) != P[k].charAt(l) ? 1 : 0;
						}
						min = Math.min(min, dist);
						if (min == 0)
							break;
					}
				}
			}
			sb.append(min).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}
