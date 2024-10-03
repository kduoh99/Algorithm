import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        Queue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(br.readLine());

            if (X == 0) {
                if (pq.isEmpty()) {
                    sb.append("0\n");
                    continue;
                }
                sb.append(pq.poll()).append('\n');
                continue;
            }
            pq.offer(X);
        }

        System.out.println(sb);
        br.close();
    }
}