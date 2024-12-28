import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] A = new Integer[N];

        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(br.readLine());

        Arrays.sort(A, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i : A)
            sb.append(i).append('\n');

        System.out.println(sb);
        br.close();
    }
}
