import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] time = br.readLine().split(" ");
		int h = Integer.parseInt(time[0]);
		int m = Integer.parseInt(time[1]);
		int needTime = Integer.parseInt(br.readLine());

		h += (needTime / 60);
		m += (needTime % 60);

		if (m >= 60) {
			++h;
			m -= 60;
		}
		
		if (h >= 24) {
			h -= 24;
		}
		
		bw.write(h + " " + m + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}