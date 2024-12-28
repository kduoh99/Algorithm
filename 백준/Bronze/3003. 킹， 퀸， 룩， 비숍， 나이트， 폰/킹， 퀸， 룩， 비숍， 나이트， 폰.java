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

		int[] peace = {1, 1, 2, 2, 2, 8};
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int j : peace) {
			bw.write(j - Integer.parseInt(st.nextToken()) + " ");
		}
		bw.write("\n");
		bw.flush();
		br.close();
		bw.close();
	}
}