import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        K--;
        StringBuilder sb = new StringBuilder();

        while (K >= 0) {
            sb.append(K % 2 == 0 ? '4' : '7');
            K = (K / 2) - 1;
        }

        System.out.println(sb.reverse());
        br.close();
    }
}
