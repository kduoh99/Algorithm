import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        StringTokenizer st = new StringTokenizer(path, "/");
        Deque<String> stack = new ArrayDeque<>();

        while (st.hasMoreTokens()) {
            String s = st.nextToken();

            if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!s.equals(".")) {
                stack.push(s);
            }
        }

        if (stack.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append("/").append(stack.pollLast());

        return sb.toString();
    }
}