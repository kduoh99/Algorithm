import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int length = (int) (Math.log10(N) + 1), result = 0;

        for (int i = 1; i <= length; i++) {
            result += (int) (i * Math.min(N - Math.pow(10, i - 1) + 1, 9 * Math.pow(10, i - 1)));
        }

        System.out.println(result);
    }
}
