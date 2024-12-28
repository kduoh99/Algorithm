import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String X = st.nextToken();
		String Y = st.nextToken();

		int revX = rev(X);
		int revY = rev(Y);

		int sum = revX + revY;
		int revSum = rev(Integer.toString(sum));

		System.out.println(revSum);
		br.close();
	}

	private static int rev(String num) {
		return Integer.parseInt(new StringBuilder(num).reverse().toString());
	}
}
