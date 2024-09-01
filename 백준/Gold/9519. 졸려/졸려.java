import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        String word = br.readLine();

        final int SIZE = word.length();
        StringBuilder sb = new StringBuilder(word);

        String original = word;
        int cycleLength = 0;

        do {
            char[] result = new char[SIZE];
            int left = 0, right = SIZE - 1;

            for (int i = 0; i < SIZE; i++) {
                if (i % 2 == 0) {
                    result[left++] = sb.charAt(i);
                } else {
                    result[right--] = sb.charAt(i);
                }
            }

            sb.setLength(0);
            sb.append(result);
            cycleLength++;
        } while (!sb.toString().equals(original));

        X %= cycleLength;

        while (X > 0) {
            char[] result = new char[SIZE];
            int left = 0, right = SIZE - 1;

            for (int i = 0; i < SIZE; i++) {
                if (i % 2 == 0) {
                    result[left++] = sb.charAt(i);
                } else {
                    result[right--] = sb.charAt(i);
                }
            }

            sb.setLength(0);
            sb.append(result);
            X--;
        }

        System.out.println(sb);
    }
}
