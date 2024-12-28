import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String str = br.readLine();
			StringBuilder sb = new StringBuilder(str);
			String rev = sb.reverse().toString();

			if (str.equals("0")) break;
			bw.write(str.equals(rev) ? "yes\n" : "no\n");
		}

		br.close();
		bw.close();
	}
}
