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
        Deque<int[]> stack = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            int idx = 0;
            int height = Integer.parseInt(st.nextToken());
            
            while (!stack.isEmpty()) {
                if (stack.peek()[1] > height) {
                    idx = stack.peek()[0];
                    break;
                }
                stack.pop();
            }
            sb.append(idx).append(' ');
            stack.push(new int[] {i + 1, height});
        }
        System.out.println(sb);
        br.close();
    }
}
