import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int n = 0, digits = 0;

        while (K > digits) {
            n++;
            digits += (int) Math.pow(2, n);
        }

        int offset = K - (digits - (int) Math.pow(2, n)) - 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int bit = (offset >> (n - 1 - i)) & 1;
            sb.append(bit == 0 ? '4' : '7');
        }

        System.out.println(sb);
        br.close();
    }
}
