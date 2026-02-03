class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = HashSet<Char>()
        var left = 0
        var right = 0
        var maxLen = 0

        for (c in s) {
            while (set.contains(c)) {
                set.remove(s[left++])
            }

            set.add(c)
            right++
            maxLen = maxOf(maxLen, right - left)
        }

        return maxLen
    }
}