import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		bw.write(compare(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		bw.flush();
		br.close();
		bw.close();
	}

	private static String compare(int a, int b) {
		if (a > b)
			return ">";
		else if (a < b)
			return "<";
		else
			return "==";
	}
}
