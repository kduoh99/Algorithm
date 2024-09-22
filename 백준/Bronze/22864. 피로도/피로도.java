import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (A > M) {
            System.out.println(0);
            return;
        }
        
        int hours = 0, works = 0, fatigue = 0;
        while (hours < 24) {
            if (fatigue + A <= M) {
                fatigue += A;
                works += B;
            } else {
                fatigue = Math.max((fatigue - C), 0);
            }
            hours++;
        }

        System.out.println(works);
        br.close();
    }
}
