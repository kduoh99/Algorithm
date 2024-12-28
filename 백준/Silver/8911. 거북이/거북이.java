import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        char[] head = {'N', 'E', 'S', 'W'};

        for (int i = 0; i < T; i++) {
            char[] command = br.readLine().toCharArray();
            int len = command.length;

            int x = 0, y = 0;
            int minX = 0, maxX = 0;
            int minY = 0, maxY = 0;
            int headIndex = 0;

            for (int j = 0; j < len; j++) {
                switch (command[j]) {
                    case 'F':
                        if (headIndex == 0) {
                            y++;
                            maxY = Math.max(maxY, y);
                        } else if (headIndex == 1) {
                            x++;
                            maxX = Math.max(maxX, x);
                        } else if (headIndex == 2) {
                            y--;
                            minY = Math.min(minY, y);
                        } else {
                            x--;
                            minX = Math.min(minX, x);
                        }
                        break;

                    case 'B':
                        if (headIndex == 0) {
                            y--;
                            minY = Math.min(minY, y);
                        } else if (headIndex == 1) {
                            x--;
                            minX = Math.min(minX, x);
                        } else if (headIndex == 2) {
                            y++;
                            maxY = Math.max(maxY, y);
                        } else {
                            x++;
                            maxX = Math.max(maxX, x);
                        }
                        break;

                    case 'L':
                        headIndex = headIndex == 0 ? head.length - 1 : headIndex - 1;
                        break;

                    case 'R':
                        headIndex = headIndex == head.length - 1 ? 0 : headIndex + 1;
                        break;
                }
            }
            int result = (maxX + Math.abs(minX)) * (maxY + Math.abs(minY));
            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}
