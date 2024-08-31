import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] command = br.readLine().toCharArray();

            int x = 0, y = 0, head = 0;
            int minX = 0, maxX = 0;
            int minY = 0, maxY = 0;

            for (char c : command) {
                if (c == 'L') {
                    head = (head + 3) % 4;
                } else if (c == 'R') {
                    head = (head + 1) % 4;
                } else {
                    int move = (c == 'F') ? 1 : -1;

                    if (head == 0) {
                        y += move;
                    } else if (head == 1) {
                        x += move;
                    } else if (head == 2) {
                        y -= move;
                    } else if (head == 3) {
                        x -= move;
                    }

                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);
                }
            }

            int result = (maxX - minX) * (maxY - minY);
            sb.append(result).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
