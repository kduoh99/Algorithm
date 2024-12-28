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
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int revA = (100 * (A % 10)) + (10 * ((A / 10) % 10)) + (A / 100);
		int revB = (100 * (B % 10)) + (10 * ((B / 10) % 10)) + (B / 100);

		bw.write(Math.max(revA, revB) + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}