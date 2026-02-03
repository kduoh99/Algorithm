class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0, max = 0;

        for (char c : s.toCharArray()) {
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }

            set.add(c);
            right++;
            max = Math.max(max, right - left);
        }

        return max;
    }
}