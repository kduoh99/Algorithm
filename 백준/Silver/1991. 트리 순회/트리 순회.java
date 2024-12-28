import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final Node head = new Node('A', null, null);
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char data = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			insertNode(head, data, left, right);
		}

		preOrder(head);
		sb.append('\n');
		inOrder(head);
		sb.append('\n');
		postOrder(head);

		System.out.println(sb);
		br.close();
	}

	static class Node {
		char data;
		Node left, right;

		Node(char data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private static void insertNode(Node head, char root, char left, char right) {
		if (head.data == root) {
			head.left = (left == '.' ? null : new Node(left, null, null));
			head.right = (right == '.' ? null : new Node(right, null, null));
		} else {
			if (head.left != null)
				insertNode(head.left, root, left, right);
			if (head.right != null)
				insertNode(head.right, root, left, right);
		}
	}

	private static void preOrder(Node node) {
		if (node == null)
			return;
		sb.append(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}

	private static void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.left);
		sb.append(node.data);
		inOrder(node.right);
	}

	private static void postOrder(Node node) {
		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.data);
	}
}
