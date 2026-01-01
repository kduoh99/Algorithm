class Solution {
    public boolean isPalindrome(String s) {
        char[] ch = s.toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray();
        int len = ch.length;
        int mid = len / 2;
        
        for (int i = 0; i < mid; i++) {
            if (ch[i] != ch[len - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
