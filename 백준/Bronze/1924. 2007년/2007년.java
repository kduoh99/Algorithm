import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final String[] months = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	private static final int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		int x = Integer.parseInt(s[0]);
		int y = Integer.parseInt(s[1]);

		for (int i = 1; i < x; i++)
			y += days[i];
		y %= 7;

		System.out.println(months[y]);
		br.close();
	}
}