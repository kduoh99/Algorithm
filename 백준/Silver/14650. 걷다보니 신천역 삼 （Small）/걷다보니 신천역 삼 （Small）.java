import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        if (N != 1)
            cnt = 2 * (int) Math.pow(3, N - 2);

        System.out.println(cnt);
        br.close();
    }
}
