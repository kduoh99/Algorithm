import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
        StringBuilder sb = new StringBuilder();
		long n = Integer.parseInt(br.readLine());
		sb.append((n * (n - 1) * (n - 2)) / 6).append("\n3");
        
		System.out.println(sb);
		br.close();
	}
}