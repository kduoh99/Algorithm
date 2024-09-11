import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(game(n)).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    private static int game(int n) {
        boolean[] rooms = new boolean[n + 1];
        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                rooms[j] = !rooms[j];
            }
        }

        for (boolean room : rooms) {
            if (room) {
                count++;
            }
        }

        return count;
    }
}
