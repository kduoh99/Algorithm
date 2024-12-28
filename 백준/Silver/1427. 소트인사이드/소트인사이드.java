import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int len = str.length();
		Integer[] arr = new Integer[len];

		for (int i = 0; i < len; i++)
			arr[i] = str.charAt(i) - '0';

		Arrays.sort(arr, Comparator.reverseOrder());
		for (int i : arr)
			sb.append(i);

		System.out.println(sb);
		br.close();
	}
}