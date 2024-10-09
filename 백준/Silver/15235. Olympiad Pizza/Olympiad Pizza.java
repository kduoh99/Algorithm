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
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(new int[] {i, Integer.parseInt(st.nextToken())});
        }

        int[] result = new int[N];
        int time = 0;

        while (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                time++;
                list.get(i)[1]--;

                if (list.get(i)[1] == 0) {
                    result[list.get(i)[0]] = time;
                    list.remove(i);
                    i--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int res : result) {
            sb.append(res).append(' ');
        }

        System.out.println(sb);
        br.close();
    }
}