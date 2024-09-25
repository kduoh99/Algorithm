import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();
        int times = 0, cur = 'A';

        for (char target : ch) {
            times += Math.min(Math.abs(target - cur), 26 - Math.abs(target - cur));
            cur = target;
        }

        System.out.println(times);
        br.close();
    }
}
