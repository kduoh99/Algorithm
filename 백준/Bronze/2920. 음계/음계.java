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
		boolean asc = true;
		boolean des = true;

		for (int i = 1; i < 9; i++) {
			if (Integer.parseInt(input[i - 1]) != i) {
				asc = false;
				break;
			}
		}

		for (int j = 8; j > 0; j--) {
			if (Integer.parseInt(input[8 - j]) != j) {
				des = false;
				break;
			}
		}

		if (asc) {
			bw.write("ascending\n");
		} else if (des) {
			bw.write("descending\n");
		} else {
			bw.write("mixed\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}