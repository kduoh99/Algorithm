import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int one = 0, two = 0, sum = 0;
        String ans = "YES";

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            sum += num;
            one += num % 2;
            two += num / 2;
        }

        if (sum % 3 > 0 || one > two)
            ans = "NO";

        System.out.println(ans);
        br.close();
    }
}
