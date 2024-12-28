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
		int X = Integer.parseInt(st.nextToken());
		String[] A = br.readLine().split(" ");

		for (int i = 0; i < N; ++i) {
			if (X > Integer.parseInt(A[i]))
				bw.write(Integer.parseInt(A[i]) + " ");
		}
		bw.write("\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
