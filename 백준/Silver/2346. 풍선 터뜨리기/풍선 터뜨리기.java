import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> dq = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            dq.offer(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        while (!dq.isEmpty()) {
            int[] nxt = dq.poll();
            int move = nxt[1];
            sb.append(nxt[0]).append(' ');

            if (!dq.isEmpty()) {
                if (move > 0) {
                    for (int i = 1; i < move; i++) {
                        dq.offer(dq.poll());
                    }
                } else {
                    for (int i = 1; i <= -move; i++) {
                        dq.offerFirst(dq.pollLast());
                    }
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}