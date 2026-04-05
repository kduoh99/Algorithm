class Solution {
    fun clearDigits(s: String): String {
        val sb = StringBuilder()

        for (c in s) {
            if (sb.isNotEmpty() && c.isDigit())
                sb.deleteAt(sb.length - 1)
            else
                sb.append(c)
        }

        return sb.toString()
    }
}