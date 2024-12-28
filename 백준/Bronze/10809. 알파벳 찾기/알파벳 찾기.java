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
		for (int i = 97; i < 123; ++i) {
			bw.write(str.indexOf((char) i) + " ");
		}
		bw.write("\n");
		bw.flush();
		br.close();
		bw.close();
	}
}