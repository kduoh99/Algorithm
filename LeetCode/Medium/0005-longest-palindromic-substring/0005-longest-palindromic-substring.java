class Solution {
    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        String answer = String.valueOf(ch[0]);
        
        for (int i = 2; i <= ch.length; i++) {
            for (int j = 0; j <= ch.length - i; j++) {
                int left = j;
                int right = j + i - 1;
                boolean flag = true;

                while (left < right) {
                    if (ch[left] != ch[right]) {
                        flag = false;
                        break;
                    }
                    left++;
                    right--;
                }

                if (flag) {
                    answer = s.substring(j, j + i);
                    break;
                }
            }
        }
        
        return answer;
    }
}