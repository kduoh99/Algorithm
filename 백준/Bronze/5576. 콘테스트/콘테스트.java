import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private static final int SIZE = 10;
    private static final int TOP = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[] W = new Integer[SIZE];
        Integer[] K = new Integer[SIZE];

        for (int i = 0; i < SIZE; i++) {
            W[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < SIZE; i++) {
            K[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(W, Comparator.reverseOrder());
        Arrays.sort(K, Comparator.reverseOrder());
        int WScore = 0, KScore = 0;

        for (int i = 0; i < TOP; i++) {
            WScore += W[i];
            KScore += K[i];
        }

        System.out.println(WScore + " " + KScore);
        br.close();
    }
}
