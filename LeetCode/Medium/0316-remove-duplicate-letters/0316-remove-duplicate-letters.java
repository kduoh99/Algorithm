class Solution {
    public String removeDuplicateLetters(String s) {
        int[] counter = new int[26];
        boolean[] used = new boolean[26];

        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            counter[idx]--;

            if (used[idx]) continue;

            while (sb.length() > 0) {
                int last = sb.length() - 1;

                if (sb.charAt(last) > c && counter[sb.charAt(last) - 'a'] > 0) {
                    used[sb.charAt(last) - 'a'] = false;
                    sb.deleteCharAt(last);
                } else {
                    break;
                }
            }

            sb.append(c);
            used[idx] = true;
        }

        return sb.toString();
    }
}