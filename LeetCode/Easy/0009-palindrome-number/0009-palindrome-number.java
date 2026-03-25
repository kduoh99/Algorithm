class Solution {
    public boolean isPalindrome(int x) {
        char[] ch = String.valueOf(x).toCharArray();
        int l = 0, r = ch.length - 1;

        while (l < r) {
            if (ch[l] != ch[r]) return false;
            l++; r--;
        }

        return true;
    }
}