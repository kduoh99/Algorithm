class Solution {
    fun removeDuplicateLetters(s: String): String {
        val counter = IntArray(26)
        val used = BooleanArray(26)

        for (c in s) {
            counter[c - 'a']++
        }

        val sb = StringBuilder()

        for (c in s) {
            val idx = c - 'a'
            counter[idx]--

            if (used[idx]) continue

            while (sb.isNotEmpty()) {
                val last = sb.last()

                if (last > c && counter[last - 'a'] > 0) {
                    used[last - 'a'] = false
                    sb.deleteAt(sb.lastIndex)
                } else {
                    break
                }
            }

            sb.append(c)
            used[idx] = true
        }

        return sb.toString()
    }
}