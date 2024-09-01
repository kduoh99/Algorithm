import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        String word = br.readLine();

        StringBuilder sb = new StringBuilder(word);
        final int SIZE = word.length();
        int cycleLength = 0;

        while (true) {
            sb = transform(sb, SIZE);
            cycleLength++;

            if (sb.toString().equals(word)) {
                break;
            }
        }

        X %= cycleLength;

        for (int i = 0; i < X; i++) {
            sb = transform(sb, SIZE);
        }

        System.out.println(sb);
    }

    private static StringBuilder transform(StringBuilder sb, int size) {
        char[] result = new char[size];
        int left = 0, right = size - 1;

        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                result[left++] = sb.charAt(i);
            } else {
                result[right--] = sb.charAt(i);
            }
        }

        sb.setLength(0);
        sb.append(result);

        return sb;
    }
}
