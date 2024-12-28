import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String[] str = br.readLine().split(" ");
			int H = Integer.parseInt(str[0]);
			int N = Integer.parseInt(str[2]);

			int floor = N % H;
			int room = (N / H) + 1;

			if (floor == 0) {
				floor = H;
				room -= 1;
			}

			String roomNumber = String.format("%d%02d", floor, room);
			bw.write(roomNumber + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
