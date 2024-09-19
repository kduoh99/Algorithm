import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] alpha = new int[26];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                int k = s.charAt(j) - 'A';
                alpha[k] += (int) Math.pow(10, s.length() - 1 - j);
            }
        }

        Arrays.sort(alpha);
        int  ans = 0, num = 9, idx = 25;

        while (alpha[idx] != 0) {
            ans += alpha[idx] * num--;
            idx--;
        }

        System.out.println(ans);
        br.close();
    }
}
