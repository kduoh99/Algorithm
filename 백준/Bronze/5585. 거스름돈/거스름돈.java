import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int total = 1000;
        final int[] changes = {500, 100, 50, 10, 5, 1};

        int purchase = Integer.parseInt(br.readLine());
        int change = total - purchase;
        int count = 0;

        for (int i : changes) {
            if (change >= i) {
                count += change / i;
                change %= i;
            }
        }

        System.out.println(count);
        br.close();
    }
}
