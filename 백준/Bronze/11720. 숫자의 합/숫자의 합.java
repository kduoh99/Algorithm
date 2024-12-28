import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int sum = 0;
		
		for (char ch : s.toCharArray())
			sum += (int) ch - '0';
		
		System.out.println(sum);
		br.close();
	}
}