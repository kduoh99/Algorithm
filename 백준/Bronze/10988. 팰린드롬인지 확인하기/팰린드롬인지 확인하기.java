import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		int d = 1;

		for (int i = 0; i < str.length() / 2; ++i) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				d = 0;
				break;
			}
		}

		bw.write(d + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}