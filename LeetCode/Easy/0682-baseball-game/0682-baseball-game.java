class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String s : operations) {
            switch (s) {
                case "+":
                    int top = stack.pop();
                    int sum = top + stack.peek();
                    stack.push(top);
                    stack.push(sum);
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }

        int total = 0;
        while (!stack.isEmpty())
            total += stack.pop();

        return total;
    }
}