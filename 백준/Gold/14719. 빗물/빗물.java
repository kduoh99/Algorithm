import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] height = new int[W];
        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int volume = 0;
        int left = 0, right = W - 1;
        int maxLeft = height[left], maxRight = height[right];

        while (left < right) {
            if (maxLeft <= maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                volume += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                volume += maxRight - height[right];
            }
        }

        System.out.println(volume);
        br.close();
    }
}
