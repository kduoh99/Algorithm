import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int stick = 64, cnt = 0;

        while (X > 0) {
            if (stick > X) {
                stick = stick >> 1;
            } else {
                X -= stick;
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
