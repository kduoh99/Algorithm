import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Set<String> set = new HashSet<>();
		String S = br.readLine();
		int len = S.length();

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++)
				set.add(S.substring(i, j));
		}

		System.out.println(set.size());
		br.close();
	}
}
