import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean[] remain = new boolean[42];
		for (int i = 0; i < 10; ++i) {
			remain[Integer.parseInt(br.readLine()) % 42] = true;
		}

		int count = 0;
		for (int j = 0; j < 42; ++j) {
			if (remain[j])
				++count;
		}
		
		bw.write(Integer.toString(count));
		bw.flush();
		br.close();
		bw.close();
	}
}