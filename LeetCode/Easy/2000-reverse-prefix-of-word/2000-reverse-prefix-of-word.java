class Solution {
    public String reversePrefix(String word, char ch) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        for (char c : word.toCharArray()) {
            if (!flag) {
                stack.push(c);

                if (c == ch) {
                    flag = true;
                    while (!stack.isEmpty())
                        sb.append(stack.pop());
                }
            } else {
                sb.append(c);
            }
        }

        return flag ? sb.toString() : word;
    }
}