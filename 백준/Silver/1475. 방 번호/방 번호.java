import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] N = br.readLine().toCharArray();
		int[] nums = new int[9];

		for (char n : N) {
			if (n == '9') n = '6';
			nums[n - '0']++;
		}

		nums[6] = (nums[6] + 1) / 2;
		Arrays.sort(nums);

		System.out.println(nums[8]);
		br.close();
	}
}