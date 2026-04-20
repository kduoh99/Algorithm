class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] c1 = new int[26];
        for (char c : s1.toCharArray())
            c1[c - 'a']++;

        int[] c2 = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            c2[s2.charAt(i) - 'a']++;

            if (i >= s1.length())
                c2[s2.charAt(i - s1.length()) - 'a']--;

            if (Arrays.equals(c1, c2)) return true;
        }

        return false;
    }
}