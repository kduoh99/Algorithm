import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] X = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            X[i] = X[i - 1] + Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] S = new int[K];
        for (int i = 0; i < K; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        List<long[]> V = new ArrayList<>();
        for (int i = 0; i < K - 1; i++) {
            long destroy = X[S[i + 1] - 1] - X[S[i] - 1];
            V.add(new long[]{destroy, S[i]});
        }

        int lastS = S[K - 1];
        long lastD = X[N] - X[lastS - 1];
        V.add(new long[]{lastD, lastS});

        V.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Long.compare(o1[1], o2[1]);
            }
            return Long.compare(o2[0], o1[0]);
        });

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < Math.min(M, V.size()); i++) {
            answer.add((int) V.get(i)[1]);
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int x : answer) {
            sb.append(x).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
