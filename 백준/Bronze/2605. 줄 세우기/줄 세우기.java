import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] orders = new int[N + 1];
        List<Integer> students = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            orders[i] = Integer.parseInt(st.nextToken());
            students.add(i - 1 - orders[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int student : students) {
            sb.append(student).append(' ');
        }

        System.out.println(sb);
        br.close();
    }
}
