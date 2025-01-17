import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] C = new Integer[N];
        for (int i = 0 ; i < N; i++)
            C[i] = Integer.parseInt(br.readLine());

        Arrays.sort(C, Collections.reverseOrder());
        int value = 0;

        for (int i = 0; i < N; i++) {
            if (i % 3 == 2) {
                continue;
            }
            value += C[i];
        }

        System.out.println(value);
        br.close();
    }
}
