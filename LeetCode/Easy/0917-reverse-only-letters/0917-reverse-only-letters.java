class Solution {
    char[] ch;

    public String reverseOnlyLetters(String s) {
        ch = s.toCharArray();
        int left = 0, right = ch.length - 1;

        while (left <= right) {
            if (!Character.isLetter(ch[left])) {
                left++;
            } else if (!Character.isLetter(ch[right])) {
                right--;
            } else {
                swap(left, right);
                left++;
                right--;
            }
        }

        return String.valueOf(ch);
    }

    private void swap(int i, int j) {
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;
    }
}