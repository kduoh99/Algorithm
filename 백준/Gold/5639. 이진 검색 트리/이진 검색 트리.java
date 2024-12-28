import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static List<Integer> pre;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		pre = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		String s;

		while ((s = br.readLine()) != null && !s.isEmpty())
			pre.add(Integer.parseInt(s));

		List<Integer> post = preToPost(0, pre.size() - 1);

		for (int i : post)
			sb.append(i).append('\n');

		System.out.println(sb);
		br.close();
	}

	private static List<Integer> preToPost(int start, int end) {
		if (start > end) return new ArrayList<>();
		List<Integer> post = new ArrayList<>();
		int rootVal = pre.get(start);
		int leftEnd = start + 1;

		while (leftEnd <= end && pre.get(leftEnd) < rootVal)
			leftEnd++;

		List<Integer> leftPost = preToPost(start + 1, leftEnd - 1);
		List<Integer> rightPost = preToPost(leftEnd, end);
		post.addAll(leftPost);
		post.addAll(rightPost);
		post.add(rootVal);

		return post;
	}
}