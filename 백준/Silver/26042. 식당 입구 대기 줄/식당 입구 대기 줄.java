import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        int size = 0, num = Integer.MAX_VALUE;

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 1:
                    int val = Integer.parseInt(st.nextToken());
                    q.offer(val);
                    if (size < q.size()) {
                        size = q.size();
                        num = val;
                    } else if (size == q.size()) {
                        num = Math.min(num, val);
                    }
                    break;
                case 2:
                    q.poll();
                    break;
            }
        }

        System.out.println(size + " " + num);
        br.close();
    }
}
