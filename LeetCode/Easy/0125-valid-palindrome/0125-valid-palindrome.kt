class Solution {
    fun isPalindrome(s: String): Boolean {
        val ch = s.lowercase().replace(Regex("[^a-z0-9]"), "").toCharArray()
        val len = ch.size
        val mid = len / 2

        for (i in 0..< mid) {
            if (ch[i] != ch[len - 1 - i]) {
                return false
            }
        }
        return true
    }
}
