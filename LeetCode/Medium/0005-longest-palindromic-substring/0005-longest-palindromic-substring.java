class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        int len = s.length();
        
        for (int i = len; i >= 1; i--) {
            for (int j = 0; j <= len - i; j++) {
                int start = j;
                int end = j + i - 1;
                boolean flag = true;
                
                while (start < end) {
                    if (s.charAt(start) != s.charAt(end)) {
                        flag = false;
                        break;
                    }
                    start++;
                    end--;
                }
                
                // 회문이고, 지금까지 찾은 가장 긴 회문보다 길다면 갱신
                if (flag && i > longest.length()) {
                    longest = s.substring(j, j + i);
                }
            }
        }
        
        return longest;
    }
}