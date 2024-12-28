import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int R = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] fib = new long[1_000_001];
        fib[0] = 0;
        fib[1] = 1;

        int N = Integer.parseInt(br.readLine());
        for (int i = 2; i <= N; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % R;
        }

        System.out.println(fib[N] % R);
        br.close();
    }
}