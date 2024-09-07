import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final char DOT = '.';
    private static int N, M;
    private static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        paint();
        print();
        br.close();
    }

    private static void paint() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                if (arr[i][j] != DOT) {
                    arr[i][M - 1 - j] = arr[i][j];
                } else if (arr[i][M - 1 - j] != DOT) {
                    arr[i][j] = arr[i][M - 1 - j];
                }
            }
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (char[] ch : arr) {
            sb.append(ch).append('\n');
        }
        System.out.println(sb);
    }
}
